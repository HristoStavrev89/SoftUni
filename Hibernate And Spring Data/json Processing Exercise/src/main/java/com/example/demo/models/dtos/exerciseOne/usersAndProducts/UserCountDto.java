package com.example.demo.models.dtos.exerciseOne.usersAndProducts;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UserCountDto {

    @Expose
    private long usersCount;
    @Expose
    private List<UserProductDto> users;

    public UserCountDto() {
        this.users = new ArrayList<>();
    }

    public long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(long usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserProductDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserProductDto> users) {
        this.users = users;
    }
}
