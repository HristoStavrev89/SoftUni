package spaceStation.core;

import spaceStation.common.Command;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddAstronaut:
                result = addAstronaut(data);
                break;
            case AddPlanet:
                result = addPlanet(data);
                break;
            case RetireAstronaut:
                result = retireAstronaut(data);
                break;
            case ExplorePlanet:
                result = explorePlanet(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String retireAstronaut(String[] data) {
        String astronautName = data[0];
        String result = this.controller.retireAstronaut(astronautName);

        return result;
    }

    private String report() {
        String result = this.controller.report();
        return result;
    }

    private String explorePlanet(String[] data) {
        String planetName = data[0];
        String result = this.controller.explorePlanet(planetName);

        return result;
    }

    private String addPlanet(String[] data) {
        String planetName = data[0];
        String[] items = data[1].split("\\s+");

        Planet planet = new PlanetImpl(planetName);



        for (int i = 0; i < items.length; i++) {
            planet.getItems().add(items[i]);
        }


        return planetName;
    }

    private String addAstronaut(String[] data) {
        String astronautName  = data[1];
        String astronautType = data[0];

       String result = this.controller.addAstronaut(astronautType,astronautName);


        return result;
    }
}
