package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPath;
import softuni.exam.models.dtos.seedDtos.offerSeedDtos.OfferRootSeed;
import softuni.exam.models.dtos.seedDtos.offerSeedDtos.OfferRootSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.Picture;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.PictureService;
import softuni.exam.service.SellerService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.xmlParser.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final CarService carService;
    private final SellerService sellerService;
    private final PictureService pictureService;


    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ValidationUtil validationUtil, FileUtil fileUtil, ModelMapper modelMapper, CarService carService, SellerService sellerService, PictureService pictureService) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.carService = carService;
        this.sellerService = sellerService;
        this.pictureService = pictureService;
    }


    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return this.fileUtil.readFile(GlobalPath.OFFERS_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        OfferRootSeed offerRootSeedDto = this.xmlParser.importFromXml(GlobalPath.OFFERS_PATH, OfferRootSeed.class);

        for (OfferRootSeedDto offerDto : offerRootSeedDto.getOffers()) {

            if (this.validationUtil.isValid(offerDto)) {

                if (this.offerRepository.getByDescriptionAndAddedOn(offerDto.getDescription(), offerDto.getAddedOn()) == null) {

                    Offer offer = this.modelMapper.map(offerDto, Offer.class);



                    Seller seller = this.sellerService.findById(offerDto.getSeller().getSeller());

                    Car car = this.carService.getCarById(offerDto.getCar().getId());



                    if (seller != null && car != null) {

                        offer.setCar(car);
                        offer.setSeller(seller);

                        List<Picture> carPics = this.pictureService.getAllPicturesByCarId(offerDto.getCar().getId());

                        offer.setPictures(carPics);



                        this.offerRepository.saveAndFlush(offer);

                        sb.append(String.format("Successfully imported offer %s - %s", offer.getAddedOn(), offer.isHasGoldStatus()))
                                .append(System.lineSeparator());
                    }
                }
            } else {
                sb.append(GlobalConstants.INVALID_OFFER).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }


}
