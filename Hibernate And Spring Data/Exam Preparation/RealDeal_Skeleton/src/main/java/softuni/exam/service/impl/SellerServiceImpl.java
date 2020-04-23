package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPath;
import softuni.exam.models.dtos.seedDtos.sellerSeedDto.SellerRootSeedDto;
import softuni.exam.models.dtos.seedDtos.sellerSeedDto.SellerSeedDto;
import softuni.exam.models.entities.Rating;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.xmlParser.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, XmlParser xmlParser, ValidationUtil validationUtil, FileUtil fileUtil, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return this.fileUtil.readFile(GlobalPath.SELLERS_PATH);
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        SellerRootSeedDto sellerRootSeedDto = this.xmlParser.importFromXml(GlobalPath.SELLERS_PATH, SellerRootSeedDto.class);

        for (SellerSeedDto sellerDto : sellerRootSeedDto.getSellers()) {

            if (this.validationUtil.isValid(sellerDto)) {

                if (this.sellerRepository.getByEmail(sellerDto.getEmail()) == null) {

                    Seller seller = this.modelMapper.map(sellerDto, Seller.class);

                    String rating = sellerDto.getRating();

                    System.out.println();

                    if (rating.equals("GOOD")) {
                        seller.setRating(Rating.GOOD);
                    } else if (rating.equals("BAD")) {
                        seller.setRating(Rating.BAD);
                    } else {
                        seller.setRating(Rating.UNKNOWN);
                    }

                    sb.append(String.format(GlobalConstants.SUCCESFULLT_IMPORT_SELLER, seller.getLastName(), seller.getEmail()))
                            .append(System.lineSeparator());

                    this.sellerRepository.saveAndFlush(seller);


                } else {
                    sb.append(GlobalConstants.ALREADY_IN_DB_SELLER)
                            .append(System.lineSeparator());
                }

            } else {
                sb.append(GlobalConstants.INVALID_SELLER).append(System.lineSeparator());
            }


        }



        return sb.toString();
    }

    @Override
    public Seller getSellerByEmail(String email) {

        return this.sellerRepository.getByEmail(email);
    }

    @Override
    public Seller findById(int id) {
        return this.sellerRepository.findById(id);
    }
}
