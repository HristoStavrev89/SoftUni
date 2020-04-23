package CarSalesman;

public class Car {
    private String carModel;
    private String modelEngine;
    private Engine engine;
    private String carWeight;
    private String carColor;


    public Car(String carModel, String modelEngine, Engine engine) {
        this.carModel = carModel;
        this.modelEngine = modelEngine;
        this.engine = engine;
        this.carWeight = "n/a";
        this.carColor = "n/a";
    }

    public void setCarWeight(String carWeight) {
        this.carWeight = carWeight;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getModelEngine() {
        return modelEngine;
    }

    public String getCarWeight() {
        return carWeight;
    }

    public String getCarColor() {
        return carColor;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "%s:\n" +
                        "Power: %d\n" +
                        "Displacement: %s\n" +
                        "Efficiency: %s\n" +
                        "Weight: %s\n" +
                        "Color: %s"
                ,this.getCarModel()
                ,this.getModelEngine()
                ,this.getEngine().getPower()
                ,this.getEngine().getDisplacement()
                ,this.getEngine().getEfficiency()
                ,this.getCarWeight()
                ,this.getCarColor());

    }
}
