package Dec_20_1018;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(", ");

        Map<String, Double> games = new LinkedHashMap<>();
        Map<String, String> gamesDlc = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].contains("-")) {
                String[] gameSplit = input[i].split("-");
                String name = gameSplit[0];
                double price = Double.parseDouble(gameSplit[1]);
                if (!games.containsKey(name)) {
                    games.put(name, price);
                }

            }
            if (input[i].contains(":")) {
                String[] gameDlc = input[i].split(":");
                String gameName = gameDlc[0];
                String dlcName = gameDlc[1];
                if (games.containsKey(gameName)) {
                    gamesDlc.put(gameName, dlcName);
                }
            }


        }
        gamesDlc.entrySet().stream()
                .sorted(Comparator.comparing(g -> games.get(g.getKey())))
                .forEach(kvp -> System.out.printf("%s - %s - %.2f%n",kvp.getKey(), kvp.getValue()
                ,(games.get(kvp.getKey()) * 1.2)/2));

        games.entrySet().stream()
                .filter(g -> !gamesDlc.containsKey(g.getKey()))
                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(kvp -> System.out.printf("%s - %.2f%n", kvp.getKey(), kvp.getValue() * 0.8));
    }

}