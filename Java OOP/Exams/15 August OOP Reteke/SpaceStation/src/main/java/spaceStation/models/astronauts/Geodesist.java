package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private static final double GEODESIST_DEFAULT_OXYGEN = 50;
    private static final double GEODESIST_OXYGEN_DECREASE = 10;

    public Geodesist(String name) {
        super(name, GEODESIST_DEFAULT_OXYGEN);
    }

    @Override
    public void breath() {
        double oxygenDecrease = this.getOxygen() - GEODESIST_OXYGEN_DECREASE;

        if (oxygenDecrease < 0){
            this.setOxygen(0);
        } else {
            this.setOxygen(oxygenDecrease);
        }
    }
}
