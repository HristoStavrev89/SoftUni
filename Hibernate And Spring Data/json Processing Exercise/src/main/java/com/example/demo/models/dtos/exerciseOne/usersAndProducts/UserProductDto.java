package com.example.demo.models.dtos.exerciseOne.usersAndProducts;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UserProductDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private CountProductsDto soldProducts;

    public UserProductDto() {

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CountProductsDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(CountProductsDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
