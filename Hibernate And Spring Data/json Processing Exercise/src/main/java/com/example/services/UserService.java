package com.example.services;

import com.example.demo.models.dtos.UserSeedDto;
import com.example.demo.models.dtos.exerciseOne.UserSoldProductsDto;
import com.example.demo.models.dtos.exerciseOne.usersAndProducts.UserCountDto;
import com.example.demo.models.entities.User;

import java.util.List;

public interface UserService {

    void seedUsers(UserSeedDto[] userSeedDtos);

    User getRandomUser();

    List<UserSoldProductsDto> getAllUsersWithAtLeastOneItemSold();

    UserCountDto findAllUsersAndTheirSoldProducts();

}
