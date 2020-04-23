import java.util.Scanner;

public class CSGO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int items = Integer.parseInt(scanner.nextLine());

        int money = Integer.parseInt(scanner.nextLine());
        int result = 0;

        if (items > 7) {
            System.out.println("Sorry, you can't carry so many things!");
        } else {


            for (int i = 0; i < items; i++) {
                String weapon = scanner.nextLine();

                if (weapon.equals("ak47")) {
                    result += 2700;
                } else if (weapon.equals("awp")) {
                    result += 4750;
                } else if (weapon.equals("sg553")) {
                    result += 3500;
                } else if (weapon.equals("grenade")) {
                    result += 300;
                } else if (weapon.equals("flash")) {
                    result += 250;
                } else if (weapon.equals("glock")) {
                    result += 500;
                } else if (weapon.equals("bazooka")) {
                    result += 5600;
                }
            }

            if (money > result) {
                System.out.printf("You bought all %d items! Get to work and defeat the bomb!", items);
            } else if (money < result) {
                int needed = result - money;
                System.out.printf("Not enough money! You need %d more money.", Math.abs(needed));
            }
        }
    }
}
