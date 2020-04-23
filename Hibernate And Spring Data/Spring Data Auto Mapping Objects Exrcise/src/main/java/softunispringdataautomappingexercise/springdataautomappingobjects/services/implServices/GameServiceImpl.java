package softunispringdataautomappingexercise.springdataautomappingobjects.services.implServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameAddDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameDetailView;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameEditDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameViewAllGamesDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Game;
import softunispringdataautomappingexercise.springdataautomappingobjects.repositories.GameRepository;
import softunispringdataautomappingexercise.springdataautomappingobjects.services.GameService;
import softunispringdataautomappingexercise.springdataautomappingobjects.services.UserService;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;

    }


    @Override
    public void addGame(GameAddDto gameAddDto) {


        if (!this.userService.isLoggedUserAdmin()) {
            System.out.println("Logged user is not admin.");
            return;
        }

        Game game = this.modelMapper.map(gameAddDto, Game.class);
        this.gameRepository.saveAndFlush(game);
        System.out.printf("Successfully added %s to the game library.%n", gameAddDto.getTitle());

    }

    @Override
    public void editGame(GameEditDto gameEditDto) {


        Game game = this.gameRepository.findById(gameEditDto.getId());

        if (game == null) {
            System.out.println("There is no game with the given id.");
            return;
        }

        if (gameEditDto.getPrice() != null) {
            game.setPrice(gameEditDto.getPrice());
        }
        if (gameEditDto.getSize() != 0) {
            game.setSize(gameEditDto.getSize());
        }
        if (gameEditDto.getTitle() != null) {
            game.setTitle(gameEditDto.getTitle());
        }
        if (gameEditDto.getDescription() != null) {
            game.setDescription(gameEditDto.getDescription());
        }
        if (gameEditDto.getImage() != null) {
            game.setImage(gameEditDto.getImage());
        }
        if (gameEditDto.getRelease_date() != null) {
            game.setRelease_date(gameEditDto.getRelease_date());
        }
        if (gameEditDto.getTrailer() != null) {
            game.setTrailer(gameEditDto.getTrailer());
        }

        // this.modelMapper.map(gameEditDto, Game.class);

        this.gameRepository.save(game);

        System.out.printf("%s game was edited.%n", game.getTitle());
    }

    @Override
    public Set<GameViewAllGamesDto> findAllGames() {
        Set<Game> gameSet = this.gameRepository.findAllGames();

        Set<GameViewAllGamesDto> viewGame = new LinkedHashSet<>();

        gameSet.forEach(game -> viewGame.add(this.modelMapper.map(game, GameViewAllGamesDto.class)));

        return viewGame;
    }

    @Override
    public GameDetailView findGameByTitle(String title) {
        Game game = this.gameRepository.findByTitle(title);

                return this.modelMapper.map(game, GameDetailView.class);
    }




}
