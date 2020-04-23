package softunispringdataautomappingexercise.springdataautomappingobjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameAddDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameItemDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameDetailView;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameEditDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user.UserLoginDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user.UserRegisterDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.services.GameService;
import softunispringdataautomappingexercise.springdataautomappingobjects.services.UserService;
import softunispringdataautomappingexercise.springdataautomappingobjects.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AppController implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final GameService gameService;




    @Autowired
    public AppController(BufferedReader bufferedReader, ValidationUtil validationUtil, UserService userService, GameService gameService) {
        this.bufferedReader = bufferedReader;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.gameService = gameService;


    }


    @Override
    public void run(String... args) throws Exception {


        while (true) {
            System.out.println("Enter a command:");
            String[] input = this.bufferedReader.readLine().split("\\|");



                    switch (input[0]) {

                case "RegisterUser":
                    if (input.length != 5) {
                        System.out.println("The given input format is not correct.");
                        break;
                    }
                    if (!input[2].equals(input[3])) {
                        System.out.println("The confirmed password does not match with the given password.");
                        break;
                    }
                    UserRegisterDto userRegisterDto =
                            new UserRegisterDto(input[1], input[2], input[4]);

                    if (this.validationUtil.isValid(userRegisterDto)) {
                        this.userService.registerUser(userRegisterDto);
                        System.out.println(String.format("%s was registered.", userRegisterDto.getFullName()));
                    } else {
                        this.validationUtil.getViolations(userRegisterDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "LoginUser":
                    UserLoginDto userLoginDto = new UserLoginDto(input[1], input[2]);
                    this.userService.loginUser(userLoginDto);
                    break;

                case "Logout":
                    this.userService.logout();
                    break;

                case "AddGame":

                    GameAddDto gameAddDto = new GameAddDto(
                            input[1],
                            new BigDecimal(input[2]),
                            Double.parseDouble(input[3]),
                            input[4],
                            input[5],
                            input[6],
                            LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    );


                    if (this.validationUtil.isValid(gameAddDto)) {
                        this.gameService.addGame(gameAddDto);

                    } else {
                        this.validationUtil.getViolations(gameAddDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;

                case "EditGame":
                    GameEditDto gameEditDto = new GameEditDto();
                    gameEditDto.setId(Long.parseLong(input[1]));

                    boolean ifIsNotValid = false;

                    for (int i = 2; i < input.length; i++) {
                        if (input[i].contains("price")) {
                            gameEditDto.setPrice(new BigDecimal(input[i].substring(input[i].indexOf("=") + 1)));
                        } else if (input[i].contains("size")) {
                            gameEditDto.setSize(Double.parseDouble(input[i].substring(input[i].indexOf("=") + 1)));
                        } else if (input[i].contains("trailer")) {
                            gameEditDto.setTrailer(input[i].substring(input[i].indexOf("=") + 1));
                        } else if (input[i].contains("thubnaiURL") || input[i].contains("image")) {
                            gameEditDto.setImage(input[i].substring(input[i].indexOf("=") + 1));
                        } else if (input[i].contains("description")) {
                            gameEditDto.setDescription(input[i].substring(input[i].indexOf("=") + 1));
                        } else if (input[i].contains("releaseDate")) {
                            gameEditDto.setRelease_date(LocalDate.parse(input[i].substring(input[i].indexOf("=") + 1), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        } else {
                            //In case there is not valid input.
                            // Example:
                            // EditGame|1|blabla=gdf
                            System.out.println("The given input for command 'EditGame' is not valid.");
                            ifIsNotValid = true;
                        }
                    }

                    if (ifIsNotValid) {
                        break;
                    }

                    //In case the given input is without any parameters.
                    // Example:
                    // EditGame|1| (missing data..)
                    if (gameEditDto.getTrailer() == null
                            && gameEditDto.getRelease_date() == null
                            && gameEditDto.getImage() == null
                            && gameEditDto.getDescription() == null
                            && gameEditDto.getSize() == 0
                            && gameEditDto.getTitle() == null) {
                        System.out.println("The given input for command 'EditGame' is not valid. The data for command 'EditGame' is missing.");
                        break;
                    }

                    System.out.println();


                    //In case someone try to edit game before Log in command.
                    if (!this.userService.isThereLoggedUser()) {
                        System.out.println("EditGame command is not valid because there is not logged ADMIN.");
                        break;
                    }


                    if (!this.userService.isLoggedUserAdmin()) {
                        System.out.println("Logged user is not admin.");
                        break;
                    }


                        if (this.validationUtil.isValid(gameEditDto)) {
                            this.gameService.editGame(gameEditDto);
                        } else {
                            this.validationUtil.getViolations(gameEditDto)
                                    .stream()
                                    .map(ConstraintViolation::getMessage)
                                    .forEach(System.out::println);
                        }
                    break;
                        case "AllGames":
                            if (this.gameService.findAllGames().isEmpty()) {
                                System.out.println("There is no added games in the library.");
                                break;
                            }
                            this.gameService.findAllGames()
                                    .forEach(game -> System.out.println(String.format("%s %.2f", game.getTitle(), game.getPrice())));
                            break;
                        case "DetailGame":

                            GameDetailView gameDetailView = this.gameService.findGameByTitle(input[1]);

                            if (gameDetailView == null) {
                                System.out.println("There is no game with the given name.");
                                break;
                            } else {
                                System.out.println(String.format("Title: %s", gameDetailView.getTitle()));
                                System.out.println(String.format("Price: %.2f", gameDetailView.getPrice()));
                                System.out.println(String.format("Description: %s", gameDetailView.getDescription()));
                                System.out.println(String.format("Release date: %s", gameDetailView.getRelease_date()));
                            }
                            break;
                        case "AddItem":
                            GameItemDto gameItemDto = new GameItemDto(input[1]);

                            if (this.validationUtil.isValid(gameItemDto)){
                                try {
                                    this.userService.addItem(gameItemDto);

                                } catch (Exception e){
                                    System.out.println("There is no logged user!");
                                 //   throw new NullPointerException(e.getMessage());
                                }
                            } else {
                                this.validationUtil.getViolations(gameItemDto)
                                        .stream()
                                        .map(ConstraintViolation::getMessage)
                                        .forEach(System.out::println);
                            }
                            break;
                        case "BuyItem":
                            this.userService.buyItem();
                            break;

                        case "RemoveItem":
                            GameItemDto gameItemDtoRemove = new GameItemDto(input[1]);

                            if (this.validationUtil.isValid(gameItemDtoRemove)){
                                try {
                                    this.userService.removeItem(gameItemDtoRemove);

                                } catch (Exception e){
                                    System.out.println("There is no logged user!");
                                    //   throw new NullPointerException(e.getMessage());
                                }
                            } else {
                                this.validationUtil.getViolations(gameItemDtoRemove)
                                        .stream()
                                        .map(ConstraintViolation::getMessage)
                                        .forEach(System.out::println);
                            }
            }
        }
    }
}
