package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut astronaut) {
        this.astronauts.putIfAbsent(astronaut.getName(), astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        Astronaut astro = this.astronauts.get(astronaut.getName());

        if (astro == null){
            return false;
        } else {
            this.astronauts.remove(astronaut.getName());
            return true;
        }
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.get(name);
    }
}
