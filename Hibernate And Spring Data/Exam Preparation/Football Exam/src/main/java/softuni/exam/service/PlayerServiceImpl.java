package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.entity.Picture;
import softuni.exam.domain.entity.Player;
import softuni.exam.domain.entity.Position;
import softuni.exam.domain.entity.Team;
import softuni.exam.domain.jsonSeedDtos.PlayerRootSeedDto;
import softuni.exam.domain.jsonViewDtos.northHubPlayers.PlayerViewDto;
import softuni.exam.domain.jsonViewDtos.northHubPlayers.TeamViewRootDto;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;


import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final TeamService teamService;
    private final PictureService pictureService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validatorUtil, TeamService teamService, PictureService pictureService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.teamService = teamService;
        this.pictureService = pictureService;
    }


    @Override
    public String importPlayers() throws IOException {
        PlayerRootSeedDto[] playerRootSeedDtos = this.gson.fromJson(new FileReader(GlobalConstants.PLAYERS_FILE_PATH), PlayerRootSeedDto[].class);

        StringBuilder sb = new StringBuilder();

        for (PlayerRootSeedDto playerRootSeedDto : playerRootSeedDtos) {

            if (this.validatorUtil.isValid(playerRootSeedDto)) {

                if (this.playerRepository
                .findByFirstNameAndLastNameAndNumber(playerRootSeedDto.getFirstName()
                ,playerRootSeedDto.getLastName()
                ,playerRootSeedDto.getNumber()) == null) {

                    Player player = this.modelMapper.map(playerRootSeedDto, Player.class);

                    Picture picture = this.pictureService.getPictureByUrl(playerRootSeedDto.getPicture().getUrl());
                    Team team = this.teamService.getTeamByName(playerRootSeedDto.getTeam().getName());

                    player.setPicture(picture);
                    player.setTeam(team);

                    Position pos = Position.valueOf(playerRootSeedDto.getPosition());

                    player.setPosition(pos);

                    this.playerRepository.saveAndFlush(player);

                } else {
                    sb.append(String.format("%s already exist in the data base!", playerRootSeedDto.getLastName())).append(System.lineSeparator());
                }

            } else {
                sb.append("Invalid player").append(System.lineSeparator());
            }

        }


       return "";
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.PLAYERS_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        BigDecimal salary = new BigDecimal(100000);

        List<Player> playerList = this.playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(salary);

        for (Player player : playerList) {

            sb.append(String.format("Player name: %s %s", player.getFirstName(), player.getLastName())).append(System.lineSeparator());
            sb.append(String.format("     Number: %d", player.getNumber())).append(System.lineSeparator());
            sb.append(String.format("     Salary: %.2f", player.getSalary())).append(System.lineSeparator());
            sb.append(String.format("     Team: %s", player.getTeam())).append(System.lineSeparator());
            
        }

       return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {

        //Hardcore value...
        String name = "North Hub";

        List<Player> playerList = this.playerRepository.findAllPlayersFromNorthHub(name);

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Team: %s", name)).append(System.lineSeparator());

        playerList
                .forEach(player -> {
                    sb.append(String.format("     Player name: %s %s - %s%n     Number: %d", player.getFirstName(), player.getLastName(), player.getPosition(), player.getNumber())).append(System.lineSeparator());

                });

        return sb.toString();
    }
    
}
