import java.util.Scanner;

public class Fitness_Card {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double money  = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();
        double ages   = Double.parseDouble(scanner.nextLine());
        String sport  = scanner.nextLine();
        double charge = 0;
        double bonus  = 0;
        double result = 0;

        if (gender.equals("m") && ages >= 19) {
            if (sport.equals("Gym")) {
                charge = 42 - money;
            } else if (sport.equals("Boxing")) {
                charge = 41 - money;
            } else if (sport.equals("Yoga")) {
                charge = 45 - money;
            } else if (sport.equals("Zumba")) {
                charge = 34 - money;
            } else if (sport.equals("Dances")) {
                charge = 51 - money;
            } else if (sport.equals("Pilates")) {
                charge = 39 - money;
            }
            if (money >= charge) {
                System.out.printf("You purchased a 1 month pass for %s.", sport);
            } else {
                System.out.printf("You don't have enough money! You need $%.2f more.", charge);
            }
        } else if (gender.equals("f") && ages >= 19) {
            if (sport.equals("Gym")) {
                charge = 35 - money;
            } else if (sport.equals("Boxing")) {
                charge = 37 - money;
            } else if (sport.equals("Yoga")) {
                charge = 42 - money;
            } else if (sport.equals("Zumba")) {
                charge = 31 - money;
            } else if (sport.equals("Dances")) {
                charge = 53 -  money;
            } else if (sport.equals("Pilates")) {
                charge = 37 - money;
            }
            if (money >= charge) {
                System.out.printf("You purchased a 1 month pass for %s.", sport);
            } else {
                System.out.printf("You don't have enough money! You need $%.2f more.", charge);
            }


        } else if (gender.equals("m") && ages < 19) {
            if (sport.equals("Gym")) {
                charge = 42 * 0.20;
                bonus  = 42 - charge;
                result = bonus - money;
            } else if (sport.equals("Boxing")) {
                charge = 41 * 0.20;
                bonus  = 41 - charge;
                result = bonus - money;
            } else if (sport.equals("Yoga")) {
                charge = 45 * 0.20;
                bonus  = 45 - charge;
                result = bonus - money;
            } else if (sport.equals("Zumba")) {
                charge = 34 * 0.20;
                bonus  = 34 - charge;
                result = bonus - money;
            } else if (sport.equals("Dances")) {
                charge = 51 * 0.20;
                bonus  = 51 - charge;
                result = bonus - money;
            } else if (sport.equals("Pilates")) {
                charge = 39 * 0.20;
                bonus  = 39 - charge;
                result = bonus - money;
            }
            if (money >= bonus) {
                System.out.printf("You purchased a 1 month for %s.", sport);
            } else {
                System.out.printf("You don't have enough money! You need $%.2f more.", result);
            }
        } else if (gender.equals("f") && ages < 19) {
            if (sport.equals("Gym")) {
                charge = 35 * 0.20;
                bonus  = 35 - charge;
                result = bonus - money;
            } else if (sport.equals("Boxing")) {
                charge = 37 * 0.20;
                bonus  = 37 - charge;
                result = bonus - money;
            } else if (sport.equals("Yoga")) {
                charge = 42 * 0.20;
                bonus  = 42 - charge;
                result = bonus - money;
            } else if (sport.equals("Zumba")) {
                charge = 31 * 0.20; //
                bonus  = 31 - charge; // 24.8
                result = bonus - money; // 14.8
            } else if (sport.equals("Dances")) {
                charge = 53 * 0.20;
                bonus  = 53 - charge;
                result = bonus - money;
            } else if (sport.equals("Pilates")) {
                charge = 37 * 0.20;
                bonus  = 37 - charge;
                result = bonus - money;
            }
            if (money >= bonus) {
                System.out.printf("You purchased a 1 month for %s.", sport);
            } else {
                System.out.printf("You don't have enough money! You need $%.2f more.", result);
            }
        }

    }
}
