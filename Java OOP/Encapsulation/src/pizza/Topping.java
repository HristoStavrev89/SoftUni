package pizza;

public class Topping {
    private String toppingType;
    private double weight;


    public Topping (String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight > 50 || weight < 1) {
            throw new IllegalArgumentException(this.getToppingType() + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    private void setToppingType(String toppingType) {
        if (!(toppingType.equals("Meat") || toppingType.equals("Veggies")
        || toppingType.equals("Cheese") || toppingType.equals("Sauce"))) {
            throw new IllegalArgumentException("Cannot place " + this.getToppingType() + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private double getWeight() {
        return this.weight;
    }

    private String getToppingType() {
        return this.toppingType;
    }

    public double calculateCalories() {
        double calories = this.getWeight() * 2;

        if (this.getToppingType().equals("Meat")) {
            calories *= 1.2;
        } else if (this.getToppingType().equals("Veggies")) {
            calories *= 0.8;
        } else if (this.getToppingType().equals("Cheese")) {
            calories *= 1.1;
        } else if (this.getToppingType().equals("Sauce")) {
            calories *= 0.9;
        }
        return calories;
    }

}
