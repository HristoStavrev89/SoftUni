package com.example.demo.implServices;
import com.example.demo.models.dtos.UserSeedDto;
import com.example.demo.models.dtos.exerciseOne.SoldProductsDto;
import com.example.demo.models.dtos.exerciseOne.UserSoldProductsDto;
import com.example.demo.models.dtos.exerciseOne.usersAndProducts.CountProductsDto;
import com.example.demo.models.dtos.exerciseOne.usersAndProducts.ProductDto;
import com.example.demo.models.dtos.exerciseOne.usersAndProducts.UserCountDto;
import com.example.demo.models.dtos.exerciseOne.usersAndProducts.UserProductDto;
import com.example.demo.models.entities.Product;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.ValidationUtil;
import com.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {

        //Not the best option of course. It will be better if I check the current dtoUser in the repository.
        //Right now is impossible to add single user.
//        if (this.userRepository.count() != 0) {
//            return;
//        }

        Arrays.stream(userSeedDtos)
                .forEach(current -> {
                    if (this.validationUtil.isValid(current)) {

                        User user = this.modelMapper.map(current, User.class);

                        System.out.println();
                        if (this.userRepository.findByFirstNameAndLastName(user.getFirstName(), user.getLastName()) == null) {
                            this.userRepository.saveAndFlush(user);
                        }



                    } else {
                        this.validationUtil.getViolations(current)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });


    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        long randomId = random
                .nextInt((int) this.userRepository.count()) + 1;

        return this.userRepository.getOne(randomId);
    }

    @Override
    public List<UserSoldProductsDto> getAllUsersWithAtLeastOneItemSold() {

        List<UserSoldProductsDto> userSoldProductsDtos = this.userRepository
                .findAllUsersWithAtLeastOneItemSoldWithBuyer()
                .stream()
                .filter(c -> c.getSold().size() > 0)
                .map(u -> {



                    List<SoldProductsDto> soldProductsDtos = new ArrayList<>();
                    u.getSold()
                            .stream()
                            .filter(p -> p.getBuyer() != null)
                            .map(current -> this.modelMapper.map(current, SoldProductsDto.class))
                            .forEach(product -> soldProductsDtos.add(product));

                    UserSoldProductsDto userSoldProductsDto = this.modelMapper.map(u, UserSoldProductsDto.class);

                    userSoldProductsDto.setSoldProducts(soldProductsDtos);


                    return userSoldProductsDto;

                }).collect(Collectors.toList());




        return userSoldProductsDtos;
    }

    @Override
    public UserCountDto findAllUsersAndTheirSoldProducts() {

        UserCountDto userCount = new UserCountDto();

        List<UserProductDto> userList = this.userRepository.findUsersAndProducts()
                .stream()
                .map(user -> {

                    List<ProductDto> productDtoList = user
                            .getSold()
                            .stream()
                            .map(product -> {
                                ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
                                return productDto;
                            }).collect(Collectors.toList());


                    CountProductsDto countProductsDto = new CountProductsDto();
                    countProductsDto.setProducts(productDtoList);
                    countProductsDto.setCount(productDtoList.size());



                    UserProductDto userProductDto = this.modelMapper.map(user, UserProductDto.class);
                    userProductDto.setSoldProducts(countProductsDto);


                    return userProductDto;

                }).collect(Collectors.toList());


        userCount.setUsers(userList);
        userCount.setUsersCount(userList.size());

        return userCount;
    }
}
