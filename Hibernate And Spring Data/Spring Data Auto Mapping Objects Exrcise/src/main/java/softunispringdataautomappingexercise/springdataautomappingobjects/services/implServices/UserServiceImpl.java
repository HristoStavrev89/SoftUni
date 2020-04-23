package softunispringdataautomappingexercise.springdataautomappingobjects.services.implServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameItemDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user.UserDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user.UserLoginDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user.UserRegisterDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Game;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Role;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.ShoppingCart;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.User;
import softunispringdataautomappingexercise.springdataautomappingobjects.repositories.GameRepository;
import softunispringdataautomappingexercise.springdataautomappingobjects.repositories.UserRepository;
import softunispringdataautomappingexercise.springdataautomappingobjects.services.UserService;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;
    private  UserDto userDto;
    private boolean loggedUser;



    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, GameRepository gameRepository) {
        this.userRepository = userRepository;

        this.modelMapper = modelMapper;

        this.gameRepository = gameRepository;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {

        User user = this.modelMapper
                .map(userRegisterDto, User.class);

        user.setRole(this.userRepository.count() == 0 ? Role.ADMIN : Role.USER);



        this.userRepository.saveAndFlush(user);

    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {

        User user = this.userRepository
                .findByEmail(userLoginDto.getEmail());

        if (user == null) {
            System.out.println("There is no registered user with the given e-mail.");
        } else {
            this.userDto = this.modelMapper.map(user, UserDto.class);
            System.out.println(String.format("Successfully logged in %s", user.getFullName()));
            this.loggedUser = true;
        }
    }

    @Override
    public void logout() {

        if (this.userDto == null) {
            System.out.println("Cannot log out. No user was logged in.");
        } else {
            String name = this.userDto.getFullName();
            this.userDto = null;
            this.loggedUser = false;
            System.out.println(String.format("User %s successfully logged out.", name));
        }
    }

    @Override
    public boolean isLoggedUserAdmin() {
        return this.userDto.getRole().equals(Role.ADMIN);
    }

    @Override
    public boolean isThereLoggedUser() {
        return this.loggedUser;
    }


    @Transactional
    @Override
    public void buyItem() {
        User user = this.userRepository.findByEmail(userDto.getEmail());

        if (!user.getShoppingCart().isEmpty()) {
            System.out.println("Successfully bought games:");
            Set<Game> gameSet = user.getGames();

            user.getShoppingCart()
                    .forEach(game -> gameSet.add(this.modelMapper.map(game, Game.class)));

            System.out.println();



        } else {
            System.out.println("There is no games into the shopping cart!");
        }
    }

    @Transactional
    @Override
    public void addItem(GameItemDto gameItemDto) {
        User user = this.userRepository.findByEmail(userDto.getEmail());
         Game game = this.gameRepository.findByTitle(gameItemDto.getTitle());



                if (game != null) {
                    user.getShoppingCart().add(this.modelMapper.map(game, ShoppingCart.class));

            System.out.println(gameItemDto.getTitle()+ " was added to cart.");
        } else {
            System.out.println("There is no game with title " + gameItemDto.getTitle());
        }
    }

    @Override
    public void removeItem(GameItemDto gameItemDto) {
        User user = this.userRepository.findByEmail(userDto.getEmail());
        Game game = this.gameRepository.findByTitle(gameItemDto.getTitle());

        if (user.getGames().contains(game)) {
            user.getGames().remove(game);
            System.out.println(gameItemDto.getTitle() + " removed from cart.");
        } else {
            System.out.println(gameItemDto.getTitle() + " is not added to the cart.");
        }
    }
}
