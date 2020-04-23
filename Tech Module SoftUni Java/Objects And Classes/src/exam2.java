import java.util.Scanner;

public class exam2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dungeon = scanner.nextLine().split("\\|");

        int health = 0;
        int coins = 0;

        boolean madeIt = false;

        for (int i = 0; i < dungeon.length; i++) {

            if (i == 0) {
                health += 100;
            }

            String[] room = dungeon[i].split(" ");

            String element = room[0];
            int value = Integer.parseInt(room[1]);
            System.out.println();

            if (element.equals("potion")) {
                if (health + value < 100) {
                    System.out.println("You healed for " + value + " hp.");
                    System.out.printf("Current health: %d hp.", health + value);
                    System.out.println();
                } else if (health + value > 100) {
                    System.out.printf("You healed for %d hp.", 100 - health);
                    health = 100;
                    System.out.println();
                    System.out.printf("Current health: %d hp.", health);
                    System.out.println();
                }
            } else if (element.equals("chest")) {
                coins += value;
                System.out.printf("You found %d coins.", value);
                System.out.println();
            } else if (!element.equals("chest") && !element.equals("potion") && health > value) {
                health = health - value;
                System.out.printf("You slayed %s.", element);
                System.out.println();
            } else if (!element.equals("chest") && !element.equals("potion") && health < value) {
                System.out.printf("You died! Killed by %s.", element);
                System.out.println();
                System.out.printf("Best room: %d", i + 1);
                System.out.println();
                break;
            }

            if (i == dungeon.length - 1 && health > 0) {
                madeIt = true;
            }


        }
        if (madeIt) {
            System.out.printf("You've made it!%nCoins: %d%nHealth: %d",coins,health);
        }


    }
}
