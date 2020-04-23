import java.util.Scanner;

public class Fitness_Card {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();
        double needed = 0;
        double discount = 0;
        double teen = 0;

        if (gender.equals("m") && age > 19) {
            if (sport.equals("Gym")) {
                needed += 42;
            } else if (sport.equals("Boxing")) {
                needed += 41;
            } else if (sport.equals("Yoga")) {
                needed += 45;
            } else if (sport.equals("Zumba")) {
                needed += 34;
            } else if (sport.equals("Dances")) {
                needed += 51;
            } else if (sport.equals("Pilates")) {
                needed += 39;
            }

            if (sum >= needed && age > 19) {
                System.out.printf("You purchased a 1 month pass for %s.", sport);
            } else {
                needed = needed - sum;
                System.out.printf("You don't have enough money! You need $%.2f more.", needed);
            }






        } else if (gender.equals("f") && age > 19 ) {
            if (sport.equals("Gym")) {
                needed += 35;
            } else if (sport.equals("Boxing")) {
                needed += 37;
            } else if (sport.equals("Yoga")) {
                needed += 42;
            } else if (scanner.equals("Zumba")) {
                needed += 31;
            } else if (sport.equals("Dances")) {
                needed += 53;
            } else if (sport.equals("Pilates")) {
                needed += 37;
            }
            if (sum >= needed && age > 19) {
                System.out.printf("You purchased a 1 month pass for %s.", sport);
            } else {
                needed = needed - sum;
                System.out.printf("You don't have enough money! You need $%.2f more.", needed);
            }





        }

        if (age <= 19 && gender.equals("m")) {
            if (sport.equals("Gym")) {
                needed += 42;
                teen += 42 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Boxing")) {
                needed += 41;
                teen += 41 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Yoga")) {
                needed += 45;
                teen += 45 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Zumba")) {
                needed += 34;
                teen += 34 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Dances")) {
                needed += 51;
                teen += 51 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Pilates")) {
                needed += 39;
                teen += 39 * 0.20;
                discount = (needed - teen) - sum;
            }
            if (sum >= discount) {
                System.out.printf("You purchased a 1 month pass for %s.", sport);
            } else {
               // discount = discount - needed;
                System.out.printf("You don't have enough money! You need $%.2f more.",discount);
            }





        } else if (age <= 19 && gender.equals("f")) {
            if (sport.equals("Gym")) {
                needed += 35;
                teen += 35 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Boxing")) {
                needed += 37;
                teen += 37 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Yoga")) {
                needed += 42;
                teen += 42 * 0.20; // 8.4
                discount = (needed - teen) - sum; // 42 - 8.4
            } else if (sport.equals("Zumba")) {
                needed += 31;
                teen += 31 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Dances")) {
                needed += 53;
                teen += 53 * 0.20;
                discount = (needed - teen) - sum;
            } else if (sport.equals("Pilates")) {
                needed += 37;
                teen += 37 * 0.20;
                discount = (needed - teen) - sum;
            }
            if (sum >= needed) {
                System.out.printf("You purchased a 1 month pass for %s.", sport);
            } else {
                //discount = needed - discount;
                System.out.printf("You don't have enough money! You need $%.2f more.",discount);
            }
        }





    }


}

