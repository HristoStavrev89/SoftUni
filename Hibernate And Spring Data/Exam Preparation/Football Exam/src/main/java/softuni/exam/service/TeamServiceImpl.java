package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.entity.Picture;
import softuni.exam.domain.entity.Team;
import softuni.exam.domain.xmlSeedDtos.xmlSeedTeamDtos.TeamRootSeedDto;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.xmlParser.XMLParser;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XMLParser xmlParser;
    private final PictureService pictureService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XMLParser xmlParser, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;

        this.pictureService = pictureService;
    }


    @Override
    
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TeamRootSeedDto teamRootSeedDto = this.xmlParser.importFromXml(GlobalConstants.TEAMS_FILE_PATH, TeamRootSeedDto.class);

        teamRootSeedDto.getTeams()
                .forEach(teamDto -> {

                    if (this.validatorUtil.isValid(teamDto)) {

                        if (this.teamRepository.findByName(teamDto.getName()) == null) {

                            Team team = this.modelMapper.map(teamDto, Team.class);

                            Picture picture = this.pictureService.getPictureByUrl(teamDto.getPicture().getUrl());

                            team.setPicture(picture);

                            sb.append(String.format("Successfully imported - %s"
                                    ,team.getName())).append(System.lineSeparator());

                            this.teamRepository.saveAndFlush(team);

                        } else {
                            sb.append(String.format("Team %s is already in the database!", teamDto.getName())).append(System.lineSeparator());
                        }



                    } else  {
                        sb.append("Invalid team").append(System.lineSeparator());
                    }
                });


       return sb.toString();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.TEAMS_FILE_PATH));
    }

    @Override
    public Team getTeamByName(String name) {
        return this.teamRepository.findByName(name);
    }

}
