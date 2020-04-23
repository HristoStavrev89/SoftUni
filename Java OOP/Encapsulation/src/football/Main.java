package football;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Team> teams = new HashMap<>();


        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split(";");


            if (data[0].equals("Team")) {
                try {
                    teams.putIfAbsent(data[1], new Team(data[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (data[0].equals("Add")) {
                if (teams.containsKey(data[1])) {
                    try {

                        Player player = new Player(data[2]
                                , Integer.parseInt(data[3])
                                , Integer.parseInt(data[4])
                                , Integer.parseInt(data[5])
                                , Integer.parseInt(data[6])
                                , Integer.parseInt(data[7]));
                        teams.get(data[1]).addPlayer(player);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println(String.format("Team %s does not exist.", data[1]));
                }
            } else if (data[0].equals("Remove")) {
                if (teams.containsKey(data[1])) {
                    teams.get(data[1]).removePlayer(data[2]);
                }
            } else if (data[0].equals("Rating")) {
                if (teams.containsKey(data[1])) {
                    int rating = (int)Math.ceil(teams.get(data[1]).getRating());
                    System.out.println(String.format("%s - %d"
                    ,data[1], rating));
                } else {
                    System.out.println("Team " + data[1] + " does not exist.");
                }
            }




        }



    }
}
