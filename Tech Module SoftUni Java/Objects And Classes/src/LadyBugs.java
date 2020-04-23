import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] ladyBugs = new int[fieldSize];

        int[] ladyBugIndexes = Arrays.stream(scanner.nextLine()
        .split("\\s+")).mapToInt(Integer::parseInt)
        .filter(e -> e >= 0 && e < fieldSize).toArray();

        for (int i = 0; i < ladyBugIndexes.length; i++) {
            ladyBugs[ladyBugIndexes[i]] = 1;
        }

        String konec = "";

        while (!"end".equals(konec = scanner.nextLine())) {
            String[] commands = konec.split(" ");

            int ladyBugIndex = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int flyLength = Integer.parseInt(commands[2]);

            if (ladyBugIndex >= 0 && ladyBugIndex < ladyBugs.length &&
                    ladyBugs[ladyBugIndex] == 1) {
                ladyBugs[ladyBugIndex] = 0;


                while (true) {
                    switch (direction) {
                        case "left":
                            ladyBugIndex -= flyLength;
                            break;
                        case "right":
                            ladyBugIndex += flyLength;
                            break;

                    }
                    if (ladyBugIndex < 0 || ladyBugIndex >= fieldSize) {
                        break;
                    }

                    if (ladyBugs[ladyBugIndex] == 1) {
                        continue;
                    }

                    if (ladyBugs[ladyBugIndex] == 0) {
                        ladyBugs[ladyBugIndex] = 1;
                        break;
                    }


                }
            }

        }


        System.out.println(
                Arrays.stream(ladyBugs)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));

    }
}
