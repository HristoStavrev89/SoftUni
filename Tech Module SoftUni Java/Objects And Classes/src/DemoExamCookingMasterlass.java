import java.util.Scanner;

public class DemoExamCookingMasterlass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        double flour = Double.parseDouble(scanner.nextLine());
        double egg = Double.parseDouble(scanner.nextLine());
        double apron = Double.parseDouble(scanner.nextLine());

        double pricePerStudent = 0;

        for (int i = 1; i <= students; i++) {
            if (i % 5 == 0) {
                pricePerStudent += egg * 10;
            } else {
                pricePerStudent += egg * 10;
                pricePerStudent += flour;
            }



        }

        double studentsApron = Math.ceil(students + (students * 0.2));

        double result = (studentsApron * apron) + pricePerStudent;

        if (budget >= result) {
            System.out.printf("Items purchased for %.2f$.",result);
        } else {
            System.out.printf("%.2f$ more needed.", result - budget);
        }











    }
}
