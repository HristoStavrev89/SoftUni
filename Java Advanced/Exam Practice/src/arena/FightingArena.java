package arena;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FightingArena {
    private String name;
    private List<Gladiator> gladiators;


    public FightingArena (String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();
    }



    public void add (Gladiator gladiator) {
        this.gladiators.add(gladiator);
    }

    public void remove (String name) {
        for (int i = 0; i < this.gladiators.size(); i++) {
            if (this.gladiators.get(i).getName().equals(name)) {
                this.gladiators.remove(i);
            }
        }
    }

    public Gladiator getGladiatorWithHighestStatPower() {

        List<Gladiator> collect = this.gladiators.stream()
                .sorted((g1, g2) -> g1.getStatPower() - g2.getStatPower())
                .collect(Collectors.toList());

        return collect.get(collect.size() - 1);

    }

    public Gladiator getGladiatorWithHighestWeaponPower() {

        List<Gladiator> collect = this.gladiators.stream()
                .sorted((g1, g2) -> g1.getWeaponPower() - g2.getWeaponPower())
                .collect(Collectors.toList());

        return collect.get(collect.size() - 1);

    }

    public Gladiator getGladiatorWithHighestTotalPower() {

        List<Gladiator> collect = this.gladiators.stream()
                .sorted((g1, g2) -> g1.getTotalPower() - g2.getTotalPower())
                .collect(Collectors.toList());

        return collect.get(collect.size() - 1);

    }

    public int getCount() {
        return gladiators.size();
    }


    @Override
    public String toString() {
        return String.format("%s - %d gladiators are participating."
        ,this.name
        ,this.getCount());
    }
}
