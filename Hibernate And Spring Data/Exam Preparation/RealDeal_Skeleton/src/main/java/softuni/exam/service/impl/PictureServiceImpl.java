package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPath;
import softuni.exam.models.dtos.seedDtos.pictureSeedDto.PictureSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final CarService carService;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil, CarService carService) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.carService = carService;
    }


    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return this.fileUtil.readFile(GlobalPath.PICTURES_PATH);
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        PictureSeedDto[] pictureSeedDtos = this.gson.fromJson(readPicturesFromFile(), PictureSeedDto[].class);

        for (PictureSeedDto pictureDto : pictureSeedDtos) {

            if (this.validationUtil.isValid(pictureDto)) {

                if (this.pictureRepository.getByName(pictureDto.getName()) == null) {


                    if (this.carService.getCarById(pictureDto.getCar()) != null) {

                        Picture picture = this.modelMapper.map(pictureDto, Picture.class);

                        Car car = this.carService.getCarById(pictureDto.getCar());

                        car.getPictures().add(picture);

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String dateDto = pictureDto.getDateAndTime();
                        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(dateDto));

                        picture.setDateAndTime(localDateTime);

                        this.pictureRepository.saveAndFlush(picture);


                    sb.append(String.format(GlobalConstants.SUCCESSFULLY_IMPORT_PICTURE, picture.getName()))
                    .append(System.lineSeparator());

                    }



                } else {
                    sb.append(String.format(GlobalConstants.ALREADY_IN_DB, pictureDto.getName()));
                }

            } else {
                sb.append(GlobalConstants.INVALID_PICTURE).append(System.lineSeparator());
            }

        }


        return sb.toString();
    }

    @Override
    public List<Picture> getAllPicturesByCarId(int id) {

        return this.pictureRepository.findAllByCar_Id(id);

    }
}
