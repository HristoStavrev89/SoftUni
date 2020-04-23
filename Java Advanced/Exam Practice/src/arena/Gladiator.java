package arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;




    public Gladiator (String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }



    public String getName() {
        return name;
    }

    public int getStatPower() {
        int stat = 0;
        stat += this.stat.getAgility();
        stat += this.stat.getFlexibility();
        stat += this.stat.getIntelligence();
        stat += this.stat.getSkills();
        stat += this.stat.getStrength();
        return stat;
    }

    public int getWeaponPower() {
        int power = 0;
        power += this.weapon.getSharpness();
        power += this.weapon.getSize();
        power += this.weapon.getSolidity();
        return power;
    }

    public int getTotalPower() {
        return getStatPower() + getWeaponPower();

    }


    @Override
    public String toString() {
        return String.format("%s - %d\n Weapon Power: %d\n Stat Power: %d"
        ,this.getName()
        ,this.getTotalPower()
        ,this.getWeaponPower()
        ,this.getStatPower());
    }
}
