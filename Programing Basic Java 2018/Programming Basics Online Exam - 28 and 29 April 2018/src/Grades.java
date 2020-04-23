import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int poor = 0;
        int middle = 0;
        double total = 0;
        int good = 0;
        int exellent = 0;

        for (int i = 1; i <= n; i++) {
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade >= 2 && grade <= 2.99) {
                poor++;
            } else if (grade >= 3 && grade <= 3.99) {
                middle++;
            } else if (grade >= 4 && grade <= 4.99) {
                good++;
            } else if (grade >= 5) {
                exellent++;
            }
            total += grade;
        }
        System.out.printf("Top students: %.2f%%%n",(exellent / (n * 1.0)) * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", good / (n * 1.0) * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", middle / (n * 1.0) * 100);
        System.out.printf("Fail: %.2f%%%n", poor / (n * 1.0) * 100);
        System.out.printf("Average: %.2f%n", total / n);





    }
}
