package Google;

public class Car {
    private String carModel;
    private String carSpeed;


    public Car (String model, String speed) {
        this.carModel = model;
        this.carSpeed = speed;
    }

    public String getCarSpeed() {
        return carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }
}
