package spaceStationRecruitment;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpaceStation {
    private String name;
    private int capacity;
    private Map<String, Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }


    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.values().size();
    }

    public void add(Astronaut astronaut) {
        if (this.getCapacity() > this.getCount()) {
            this.data.put(astronaut.getName(), astronaut);
        }
    }

    public boolean remove(String name) {
        if (this.data.containsKey(name)) {
            this.data.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public Astronaut getOldestAstronaut() {

        Astronaut astronaut = null;
        int ageMax = 0;
        for (Map.Entry<String, Astronaut> stringAstronautEntry : this.data.entrySet()) {
            if (stringAstronautEntry.getValue().getAge() > ageMax) {
                ageMax = stringAstronautEntry.getValue().getAge();
                astronaut = stringAstronautEntry.getValue();
            }
        }
        return astronaut;
    }

    public Astronaut getAstronaut(String name) {
        return this.data.get(name);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Astronaut> stringAstronautEntry : this.data.entrySet()) {
            sb.append(stringAstronautEntry.getValue().toString())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

}
