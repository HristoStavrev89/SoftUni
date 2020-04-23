import java.util.Scanner;

public class Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int n = Integer.parseInt(scanner.nextLine());
        double firstDay = Double.parseDouble(scanner.nextLine());

        double total = firstDay;

        for (int i = 0; i < n; i++) {
            double norm = Double.parseDouble(scanner.nextLine());

            firstDay = firstDay + firstDay * (norm / 100);

            total += firstDay;

        }

        if (total >= 1000) {
            total = Math.ceil(total - 1000);
            System.out.printf("You've done a great job running %.0f more kilometers!", total);
        } else {
            total = Math.ceil(1000 - total);
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", total);
        }



    }
}
