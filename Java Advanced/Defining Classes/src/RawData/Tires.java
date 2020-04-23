package RawData;

public class Tires {
    private double tire1Pressure;
    private int tire1age;

    private double tire2Pressure;
    private int tire2age;

    private double tire3Pressure;
    private int tire3age;

    private double tire4Pressure;
    private int tire4age;


    public Tires(double tire1Pressure, int tire1age, double tire2Pressure, int tire2age, double tire3Pressure, int tire3age, double tire4Pressure, int tire4age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1age = tire1age;
        this.tire2Pressure = tire2Pressure;
        this.tire2age = tire2age;
        this.tire3Pressure = tire3Pressure;
        this.tire3age = tire3age;
        this.tire4Pressure = tire4Pressure;
        this.tire4age = tire4age;
    }

    public double getTire1Pressure() {
        return tire1Pressure;
    }



    public double getTire2Pressure() {
        return tire2Pressure;
    }



    public double getTire3Pressure() {
        return tire3Pressure;
    }



    public double getTire4Pressure() {
        return tire4Pressure;
    }


}
