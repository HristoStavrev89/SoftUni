package vehicles;

public class Bus extends Vehicle {

    private final static double AIRCONDITION = 1.4;

    protected Bus(double fuelQuantity, double fuelConsumptionKM, int tankCapacity) {
        super(fuelQuantity, fuelConsumptionKM + AIRCONDITION, tankCapacity);

    }






}
