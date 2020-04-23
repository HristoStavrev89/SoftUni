package CarSalesman;

public class Engine {

    private int power;

    private String displacement;
    private String efficiency;

    public Engine (int power) {
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
