package vehicles;

public class Truck extends Vehicle {
    private final static double AIRCONTITION_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumptionKM, int tankCapacity) {
        super(fuelQuantity, fuelConsumptionKM + AIRCONTITION_CONSUMPTION, tankCapacity);
    }


    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }



}
