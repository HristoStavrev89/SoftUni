package healthyHeaven;

import java.util.*;

public class Restaurant {
    private String name;
    private Map<String, Salad> salads;

    public Restaurant(String name) {
        this.name = name;
        this.salads = new LinkedHashMap<>();
    }


    public void add(Salad salad){
        this.salads.putIfAbsent(salad.getName(), salad);
    }

    public boolean buy(String name){
        if (this.salads.containsKey(name)) {
            this.salads.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public Salad getHealthiestSalad(){
        int healthest = Integer.MAX_VALUE;
        Salad salad = null;

        for (Map.Entry<String, Salad> stringSaladEntry : this.salads.entrySet()) {
            if (stringSaladEntry.getValue().getTotalCalories() < healthest) {
                healthest = stringSaladEntry.getValue().getTotalCalories();
                salad = stringSaladEntry.getValue();
            }
        }
        return salad;
    }

    public String generateMenu(){
        StringBuilder sb = new StringBuilder();
        String resturant = String.format("%s have %d salads:", this.name, this.salads.values().size());
        sb.append(resturant).append(System.lineSeparator());

        for (Map.Entry<String, Salad> stringSaladEntry : this.salads.entrySet()) {
            sb.append(stringSaladEntry.getKey())
            .append(System.lineSeparator());
        }
        return sb.toString().trim();

    }


}
