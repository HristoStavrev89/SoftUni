package CatLady;

public class Cat {
    private String name;
    private double skillValue;

    public Cat (String name, double skillValue) {
        this.name = name;
        this.skillValue = skillValue;
    }



    @Override
    public String toString() {
        return String.format("%s %.2f", this.name, this.skillValue);
    }
}
