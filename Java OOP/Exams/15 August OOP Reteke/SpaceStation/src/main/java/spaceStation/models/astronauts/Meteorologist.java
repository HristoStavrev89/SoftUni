package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private static final double METEREOLOGIST_DEFAULT_OXYGEN = 90;
    private static final double METEREOLOGIST_OXYGEN_DECREASE = 10;


    public Meteorologist(String name) {
        super(name, METEREOLOGIST_DEFAULT_OXYGEN);
    }

    @Override
    public void breath() {
        double oxygenDecrease = this.getOxygen() - METEREOLOGIST_OXYGEN_DECREASE;

        if (oxygenDecrease < 0){
            this.setOxygen(0);
        } else {
            this.setOxygen(oxygenDecrease);
        }
    }
}
