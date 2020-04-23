package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.util.Collection;

public class MissionImpl implements Mission {



    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {



        while (planet.getItems().size() != 0) {
            for (Astronaut astronaut : astronauts) {
                while (astronaut.canBreath()) {
                    for (String item : planet.getItems()) {
                        astronaut.breath();
                        astronaut.getBag().getItems().add(item);
                        planet.getItems().remove(item);
                        if (!astronaut.canBreath()){
                            break;
                        }
                    }
                }
            }
        }
    }
}
