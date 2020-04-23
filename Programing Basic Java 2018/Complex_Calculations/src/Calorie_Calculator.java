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

        double BNMMan = 66 + (13.7 * weight) + (5 * heightCM) - (6.8 * age);

        double BNMFemale = 655 + (9.6 * weight) + (1.8 * heightCM) - (4.7 * age);

        if (gender.equals("m")) {
            if (activity.equals("sedentary")) {
                BNMMan = BNMMan * 1.2;
            } else if (activity.equals("lightly active")) {
                BNMMan = BNMMan * 1.375;
            } else if (activity.equals("moderately active")) {
                BNMMan = BNMMan * 1.55;
            } else if (activity.equals("very active")) {
                BNMMan = BNMMan * 1.725;
            }
            System.out.printf("To maintain your current weight you will need %.0f calories per day.", Math.ceil(BNMMan));
        }
        if (gender.equals("f")) {
            if (activity.equals("sedentary")) {
                BNMFemale = BNMFemale * 1.2;
            } else if (activity.equals("lightly active")) {
                BNMFemale = BNMFemale * 1.375;
            } else if (activity.equals("moderately active")) {
                BNMFemale = BNMFemale * 1.55;
            } else if (activity.equals("very active")) {
                BNMFemale = BNMFemale * 1.725;
            }
            System.out.printf("To maintain your current weight you will need %.0f calories per day.", Math.ceil(BNMFemale));;
        }


    }
}
