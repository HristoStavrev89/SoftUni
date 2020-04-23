package entities.implementations;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double HEALTH_POINTS = 100.0;
    private static final double ATTACK_POINTS_MODIFER = 40;
    private static final double DEFENCE_POINTS_MODIFIER = 30;
    private boolean defenceMode;


    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, HEALTH_POINTS);
        this.setDefenceModeTrue();
    }


    @Override
    public boolean getDefenseMode() {
        return this.defenceMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.setDefenseModeFalse();
        } else {
            this.setDefenceModeTrue();
        }
    }

    private void setDefenceModeTrue() {
        this.defenceMode = true;
        super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFER);
        super.setDefensePoints(super.getDefensePoints() + DEFENCE_POINTS_MODIFIER);
    }

    private void setDefenseModeFalse() {
        this.defenceMode = false;
        super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFER);
        super.setDefensePoints(super.getDefensePoints() - DEFENCE_POINTS_MODIFIER);
    }


    @Override
    public String toString() {
       String mode = "";

       if (this.getDefenseMode()) {
           mode = "ON";
       } else {
           mode = "OFF";
       }
       String tankInfo = super.toString() + String.format(" *Defense Mode(%s)", mode);
       return tankInfo;
    }
}
