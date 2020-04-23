package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPaths;
import softuni.exam.models.dtos.seedDtos.seedXmls.seedPlanes.PlaneRootSeedDto;
import softuni.exam.models.dtos.seedDtos.seedXmls.seedPlanes.PlaneSeedDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.xmlParser.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@Transactional
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return this.fileUtil.readFile(GlobalPaths.PLANES_PATH);
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();


        PlaneRootSeedDto planeRootSeedDto = this.xmlParser.importFromXml(GlobalPaths.PLANES_PATH, PlaneRootSeedDto.class);

        for (PlaneSeedDto planeDto : planeRootSeedDto.getPlanes()) {

            if (this.validationUtil.isValid(planeDto)) {

                if (this.planeRepository.findByRegisterNumber(planeDto.getRegisterNumber()) == null) {

                    Plane plane = this.modelMapper.map(planeDto, Plane.class);

                    sb.append(String.format(GlobalConstants.SUCCESSFULLY_IMPORTED_PLANE, plane.getRegisterNumber()))
                            .append(System.lineSeparator());

                    this.planeRepository.saveAndFlush(plane);

                }

            } else {
                sb.append(GlobalConstants.INVALID_PLANE)
                        .append(System.lineSeparator());
            }

        }

        return sb.toString();
    }

    @Override
    public Plane getPlaneByRegisterNumber(String regNumber) {
        return this.planeRepository.findByRegisterNumber(regNumber);

    }
}
