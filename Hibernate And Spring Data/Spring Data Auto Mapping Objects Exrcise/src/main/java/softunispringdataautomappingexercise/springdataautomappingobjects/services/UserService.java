package softunispringdataautomappingexercise.springdataautomappingobjects.services;

import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameItemDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user.UserLoginDto;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isLoggedUserAdmin();

    boolean isThereLoggedUser();

    void buyItem();

    void addItem(GameItemDto gameItemDto);

    void removeItem(GameItemDto gameItemDto);

}
