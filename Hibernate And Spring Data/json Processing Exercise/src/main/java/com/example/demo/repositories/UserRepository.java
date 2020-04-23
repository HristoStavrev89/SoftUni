package com.example.demo.repositories;

import com.example.demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Query for Successfully Sold Products
    @Query("SELECT u FROM User AS u WHERE u.sold.size > 0 ORDER BY u.lastName, u.firstName")
    List<User> findAllUsersWithAtLeastOneItemSoldWithBuyer();

    //Query for Users and Products
    @Query("SELECT u FROM User AS u ORDER BY u.sold.size DESC, u.lastName")
    List<User> findUsersAndProducts();

    User findByFirstNameAndLastName(String firstName, String lastName);

}
