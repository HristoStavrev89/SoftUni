package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.entity.Picture;
import softuni.exam.domain.xmlSeedDtos.xmlSeedPictureDtos.PictureRootSeedDto;
import softuni.exam.domain.xmlSeedDtos.xmlSeedPictureDtos.PictureSeedDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.xmlParser.XMLParser;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XMLParser xmlParser;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XMLParser xmlParser) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public String importPictures() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        PictureRootSeedDto pictureRootSeedDto = this.xmlParser
                .importFromXml(GlobalConstants.PICTURE_FILE_PATH, PictureRootSeedDto.class);



        pictureRootSeedDto.getPictures()
                .forEach(pic -> {

                    if (this.validatorUtil.isValid(pic)) {

                        if (this.pictureRepository.findByUrl(pic.getUrl()) == null) {

                            Picture picture = this.modelMapper.map(pic, Picture.class);

                            sb.append(String.format("Successfully imported picture - %s", picture.getUrl())).append(System.lineSeparator());

                            this.pictureRepository.saveAndFlush(picture);



                        } else {
                            sb.append("Picture is already in the database!").append(System.lineSeparator());
                        }

                    } else {
                        sb.append("Invalid picture").append(System.lineSeparator());
                    }


                });


        return sb.toString();

    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.PICTURE_FILE_PATH));
    }

    @Override
    public Picture getPictureByUrl(String url) {
        return this.pictureRepository.findByUrl(url);
    }


}
