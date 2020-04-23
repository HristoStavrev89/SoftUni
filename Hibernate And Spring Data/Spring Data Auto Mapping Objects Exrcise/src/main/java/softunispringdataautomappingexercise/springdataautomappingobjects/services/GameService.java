package softunispringdataautomappingexercise.springdataautomappingobjects.services;


import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameAddDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameDetailView;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameEditDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameViewAllGamesDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Game;

import java.util.Set;

public interface GameService {

    void addGame(GameAddDto gameAddDto);

    void editGame(GameEditDto gameEditDto);

    Set<GameViewAllGamesDto> findAllGames();

    GameDetailView findGameByTitle(String title);



}
