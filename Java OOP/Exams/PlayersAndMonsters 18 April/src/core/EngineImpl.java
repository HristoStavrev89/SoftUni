package core;

import common.Command;
import core.interfaces.Engine;
import core.interfaces.ManagerController;
import models.players.interfaces.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private BufferedReader reader;
    private ManagerController controller;

    public EngineImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.controller = new ManagerControllerImpl();
    }


    @Override
    public void run() {
       while (true) {
           String result = null;

           try {
               result = processInput();

               if (Command.Exit.name().equals(result)) {
                   break;
               }

           } catch (IOException | IllegalArgumentException e) {
               result = e.getMessage();
           }

           System.out.println(result);
       }
    }

    private String processInput() throws IOException {
        String input = reader.readLine();

        String[] tokens = input.split("\\s+");

        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = null;

        Command command = Command.valueOf(tokens[0]);

        switch (command) {
            case AddPlayer:
                result = addPlayer(data);
                break;
            case AddCard:
                result = addCard(data);
                break;
            case AddPlayerCard:
                result = addPlayerCard(data);
                break;
            case Fight:
                result = fight(data);
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

    private String report() {
        String result = this.controller.report();

        return result;
    }

    private String fight(String[] data) {
        String attackUser = data[0];
        String enemyUser = data[1];

        String result = this.controller.fight(attackUser, enemyUser);

        return result;
    }

    private String addPlayerCard(String[] data) {
        String userName = data[0];
        String cardName = data[1];

        String result = this.controller.addPlayerCard(userName, cardName);

        return result;
    }

    private String addCard(String[] data) {
        String cardType = data[0];
        String cardName = data[1];

        String result = this.controller.addCard(cardType, cardName);

        return result;

    }

    private String addPlayer(String[] data) {
        String type = data[0];
        String name = data[1];


        String result = this.controller.addPlayer(type, name);

        return result;
    }
}
