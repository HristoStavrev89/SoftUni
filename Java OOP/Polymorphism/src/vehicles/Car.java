package vehicles;

public class Car extends Vehicle {

    private final static double AIRCONDITION_CONSUMPTION = 0.9;


    protected Car(double fuelQuantity, double fuelConsumptionKM, int tankCapacity) {
        super(fuelQuantity, fuelConsumptionKM + AIRCONDITION_CONSUMPTION, tankCapacity);
    }
}
