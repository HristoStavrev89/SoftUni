package com.example.demo.models.dtos.exerciseOne.usersAndProducts;

import com.example.demo.models.entities.Product;
import com.google.gson.annotations.Expose;

import java.util.List;

public class CountProductsDto {

    @Expose
    private long count;
    @Expose
    private List<ProductDto> products;

    public CountProductsDto() {
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
