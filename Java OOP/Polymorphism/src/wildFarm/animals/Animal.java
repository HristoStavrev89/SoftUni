package wildFarm.animals;



import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;


    protected Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }


    protected String getAnimalType() {
        return this.animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }


    @Override
    public String toString() {

        DecimalFormat format = new DecimalFormat("#.##");

        return
                String.format("%s[%s, %s, region, %d]",
                this.getAnimalType(),
                this.animalName,
                format.format(this.animalWeight),
                this.foodEaten

        );
    }
}
