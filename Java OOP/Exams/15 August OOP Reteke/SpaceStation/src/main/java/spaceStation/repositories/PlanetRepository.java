package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets;


    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    @Override
    public void add(Planet planet) {
        this.planets.putIfAbsent(planet.getName(), planet);
    }

    @Override
    public boolean remove(Planet planet) {
        Planet currentPlanet = this.planets.get(planet.getName());

        if (currentPlanet == null){
            return false;
        } else {
            this.planets.remove(planet.getName());
            return true;
        }
    }

    @Override
    public Planet findByName(String planet) {
        return this.planets.get(planet);
    }
}
