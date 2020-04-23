package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Bag;
import spaceStation.models.bags.Backpack;


public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Backpack bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag =  new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        boolean isTrue;
        if (this.getOxygen() > 0){
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }



    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0){
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }
}
