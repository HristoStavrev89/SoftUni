package SpeedRacing;

public class Cars {

    private double fuelAmount;
    private double fuelCostPerKm;
    private int totaKm;



    public Cars (double fuelAmount, double fuelPriceKm) {
       // this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelPriceKm;
    }


    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

//    public int setTravelKm (int km) {
//        int result = 0;
//

    public int getTotaKm() {
        return totaKm;
    }

    public void setTotaKm(int totaKm) {
        this.totaKm = totaKm;
    }
//        result += km;
//
//        return result;
//    }



}
