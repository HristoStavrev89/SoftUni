package vehicles;


import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionKM;
    private int tankCapacity;



    protected Vehicle(double fuelQuantity, double fuelConsumptionKM, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionKM = fuelConsumptionKM;
        this.tankCapacity = tankCapacity;
    }



    protected String drive(double distance) {
        String ouput = null;

        DecimalFormat format = new DecimalFormat("#.##");

        double tryToDrive = this.fuelConsumptionKM * distance;
        if (tryToDrive <= this.fuelQuantity) {
              ouput = String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(distance));
              this.fuelQuantity -= tryToDrive;
        } else {
            ouput = String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        return ouput;
    }

    public void refuel(double liters) {

        if (liters < 1) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    public void driveEmpty() {
        this.fuelConsumptionKM = this.fuelConsumptionKM - 1.4;

    }


    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }


}
