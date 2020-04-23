package wildFarm.animals;

public class Cat extends Felime {
    private String breed;

    protected Cat(String animalType, String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


    @Override
    public String toString() {
        String baseToStr = super.toString();
        int index = baseToStr.indexOf(",");

        StringBuilder stringBuilder = new StringBuilder(baseToStr);

        stringBuilder.insert(index + 2, this.breed + ", ");

        return stringBuilder.toString();

    }
}
