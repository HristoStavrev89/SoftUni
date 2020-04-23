package shopping;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;


    public Person (String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw  new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }



    public void buyProduct (Product product) {
        if (product.getCost() < this.getMoney()) {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.println(String.format("%s bought %s"
            ,this.getName(), product.getName()));
        } else {
            System.out.println(String.format("%s can't afford %s"
            ,this.getName(),product.getName()));
        }
    }






}
