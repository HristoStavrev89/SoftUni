import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double baseSalary = Double.parseDouble(scanner.nextLine());
        int timeService = Integer.parseInt(scanner.nextLine());
        String syndicate = scanner.nextLine();

        double currentSalary = baseSalary;
        int year;
        for (year = 1; year <= timeService; year++) {
            currentSalary = currentSalary * 1.06;
            if (year % 10 == 5) {
                currentSalary += 100;
            } else if (year % 10 == 0) {
                currentSalary += 200;
            }
            if (syndicate.equals("Yes") && (year % 10 != 5 || year % 10 != 0)) {
                currentSalary = currentSalary * 0.99;
            }
        }
        if (currentSalary >= 5000) {
            System.out.printf("Current salary: 5000.00%n");
            System.out.printf("0 more years to max salary.%n");
        } else if (currentSalary < 5000) {
            double toMaxSalary = currentSalary;
            while (toMaxSalary < 5000) {
                toMaxSalary = toMaxSalary * 1.06;
                if (year % 10 == 5) {
                    toMaxSalary += 100;
                } else if (year % 10 == 0) {
                    toMaxSalary += 200;
                }
                if (syndicate.equals("Yes") && (year % 10 != 5 || year % 10 != 0)) {
                    toMaxSalary = toMaxSalary * 0.99;
                }
                year++;
            }
            System.out.printf("Current salary: %.2f%n", currentSalary);
            System.out.printf("%d more years to max salary.%n", year - 2 - timeService);
        }
    }
}