import java.util.Scanner;

public class Calorie_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String gender = scanner.nextLine();
        double weight = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        int age = Integer.parseInt(scanner.nextLine());
        String activity = scanner.nextLine();
        double heightCM = height * 100;

        double BNMMans = 66 + (13.7 * weight) + (5 * heightCM) - (6.8 * age);
        double BNMWomans = 655 + (9.6 * weight) + (1.8 * heightCM) - (4.7 * age);


        if (gender.equals("m")) {
            if (activity.equals("sedentary")) {
                BNMMans = BNMMans * 1.2;
            } else if (activity.equals("lightly active")) {
                BNMMans = BNMMans * 1.375;
            } else if (activity.equals("moderately active")) {
                BNMMans = BNMMans * 1.55;
            } else if (activity.equals("very active")) {
                BNMMans = BNMMans * 1.725;
            }
            System.out.printf("To maintain your current weight you will need %.0f calories per day.", Math.ceil(BNMMans));
        }

        if (gender.equals("f")) {
            if (activity.equals("sedentary")) {
                BNMWomans = BNMWomans * 1.2;
            } else if (activity.equals("lightly active")) {
                BNMWomans = BNMWomans * 1.375;
            } else if (activity.equals("moderately active")) {
                BNMWomans = BNMWomans * 1.55;
            } else if (activity.equals("very active")) {
                BNMWomans = BNMWomans * 1.725;
            }
            System.out.printf("To maintain your current weight you will need %.0f calories per day.", Math.ceil(BNMWomans));
        }


    }
}
