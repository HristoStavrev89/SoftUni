import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DemoExamBreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> dayEvents = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        int coins = 100;
        int energy = 0;


        for (int i = 0; i < dayEvents.size(); i++) {
            String[] input = dayEvents.get(i).split("-");

            String event = input[0];
            int value = Integer.parseInt(input[1]);

            if (i == 0) {
                energy += 100;
            }

            if (event.equals("rest") && energy >= 100) {
                System.out.printf("You gained 0 energy.%n");
                energy = 100;
                System.out.printf("Current energy: %d.%n", energy);
            } else if (event.equals("rest") && energy < 100 && value + energy < 100) {
                energy += value;
                System.out.printf("You gained %d energy.%n", value);
                System.out.printf("Current energy: %d.%n", energy);

            } else if (event.equals("rest") && energy + value > 100 && energy < 100) {
                System.out.printf("You gained %d energy.%n", (energy + value) - 100);
                energy = 100;
                System.out.printf("Current energy: %d%n", energy);


            }
            if (event.equals("order") && energy - 30 >= 0) {
                energy -= 30;
                coins += value;
                System.out.printf("You earned %d coins.%n", value);
            } else if (event.equals("order") && energy - 30 < 0) {
                energy += 50;
                System.out.println("You had to rest!");
            }

            if (!event.equals("order") && !event.equals("rest") && coins - value >= 0) {
                coins -= value;
                System.out.printf("You bought %s.%n",event);
            } else if (!event.equals("order") && !event.equals("rest") && coins - value < 0) {
                System.out.printf("Closed! Cannot afford %s.%n",event);
                return;
            }

            if (i + 1 == dayEvents.size()) {
                System.out.println("Day completed!");
                System.out.println("Coins: " + coins);
                System.out.println("Energy: " + energy);
            }
        }


    }
}
