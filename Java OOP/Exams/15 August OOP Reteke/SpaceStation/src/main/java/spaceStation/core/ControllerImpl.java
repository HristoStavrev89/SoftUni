package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;

        if (Biologist.class.getSimpleName().equals(type)){
            astronaut = new Biologist(astronautName);
        } else if (Geodesist.class.getSimpleName().equals(type)){
            astronaut = new Geodesist(astronautName);
        } else if (Meteorologist.class.getSimpleName().equals(type)){
            astronaut = new Meteorologist(astronautName);
        }

        if (astronaut == null){
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        String messege = String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
        return messege;


    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (int i = 0; i < items.length; i++) {
            planet.getItems().add(items[i]);
        }
        this.planetRepository.add(planet);

        String messege = String.format(ConstantMessages.PLANET_ADDED, planetName);
        return messege;
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);

        if (astronaut == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        this.astronautRepository.remove(astronaut);
        String messege = String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
        return messege;
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = this.planetRepository.findByName(planetName);

        List<Astronaut> astronauts60Oxygen = this.astronautRepository
                .getModels().stream().filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (astronauts60Oxygen.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        this.mission.explore(planet, astronauts60Oxygen);

        int deadAstronuts = astronauts60Oxygen.size() - this.astronautRepository.getModels().size();

        String messege = String.format(ConstantMessages.PLANET_EXPLORED,planetName, deadAstronuts);

        exploredPlanets++;

        return messege;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());

        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            String reformat = astronaut.getBag().getItems().toString().replaceAll("[\\]\\[]", "");

            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME,astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator());

            if (astronaut.getBag().getItems().size() == 0){
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
            } else {
                sb.append("Bag items: " + reformat);
            }
                    sb.append(System.lineSeparator());



        }



        return sb.toString().trim();
    }
}
