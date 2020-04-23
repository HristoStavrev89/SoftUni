package RawData;

public class Truck {
    private Engine engine;
    private Cargo cargo;
    private Tires tires;


    public Truck(Engine engine, Cargo cargo, Tires tires) {
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }
}
