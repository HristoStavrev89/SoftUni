package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingsNum;


    public Pizza(String name, int toppingsNum) {
        this.setName(name);
        this.setToppings(toppingsNum);
        this.toppings = new ArrayList<>(this.toppingsNum);
    }

    private void setToppings(int toppingsNum) {
        if (toppingsNum > 10 || toppingsNum < 0) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsNum = toppingsNum;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15 || name.length() < 1) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public double getOverallCalories() {
        return this.dough.calculateCalories()
                + this.toppings.stream()
                .mapToDouble(Topping::calculateCalories).sum();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() < this.toppingsNum) {
            this.toppings.add(topping);
        }

    }


}
