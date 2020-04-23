import java.util.Scanner;

public class Ivanovis_Family {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());
        double third = Double.parseDouble(scanner.nextLine());


        double gifts = first + second + third;

        double taxBudget = budget - gifts;
        double result = taxBudget - (taxBudget * 0.10);

        System.out.printf("%.2f",result);

    }
}
