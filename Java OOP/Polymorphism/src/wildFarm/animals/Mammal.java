package wildFarm.animals;



public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }


    @Override
    public void eat(Food food) {
        boolean foodIsMeat = food.getClass().getSimpleName().equals("Meat");

        if (foodIsMeat && !(this instanceof Felime)) {

            String messege = (this.getAnimalType() + "s are not eating that type of food!")
                    .replaceAll("Mouses", "Mice");

            throw new IllegalArgumentException(messege);
        } else if (!foodIsMeat && this.getAnimalType().equals("Tiger")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");

        }

        super.eat(food);
    }


    @Override
    public String toString() {
        return super.toString().replaceAll("region", this.livingRegion);
    }
}
