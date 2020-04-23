package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> vegetables;



    public Salad(String name) {
        this.name = name;
        this.vegetables = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
       int calories = this.vegetables.stream()
                .mapToInt(cal -> cal.getCalories()).sum();

        return calories;
    }

    public int getProductCount() {
        return this.vegetables.size();
    }

    public void add(Vegetable vegetable) {
        this.vegetables.add(vegetable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String currentSald = String.format("* Salad %s is %d calories and have %d products:"
        ,this.getName(), this.getTotalCalories(), this.getProductCount());
        sb.append(currentSald).append(System.lineSeparator());

        for (Vegetable vegetable : this.vegetables) {
            sb.append(vegetable.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
