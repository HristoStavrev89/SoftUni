package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readIntegerArray(scanner.nextLine());

        Galactic galactic = new Galactic(dimensions[0], dimensions[1]);

        Player player = new Player();

        GalacticCluster cluster = new GalacticCluster(galactic);

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {

            int[] plaeyrPositions = readIntegerArray(command);
            int playerRow = plaeyrPositions[0];
            int playerCol = plaeyrPositions[1];

            command = scanner.nextLine();

            int[] evilPositions = readIntegerArray(command);
            int evilRow = evilPositions[0];
            int evilCol = evilPositions[1];

            cluster.moveEvilForce(evilRow, evilCol);

           int starsToAdd = cluster.collectPlayerStars(playerRow, playerCol);

           player.addStars(starsToAdd);

            command = scanner.nextLine();
        }
        System.out.println(player.getStars());
    }

    public static int[] readIntegerArray(String line) {
      return Arrays.stream(line
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
