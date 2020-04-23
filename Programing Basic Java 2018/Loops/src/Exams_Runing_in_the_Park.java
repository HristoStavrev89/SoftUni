import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class Exams_Runing_in_the_Park {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int caloriesPerMinute = 400 / 20;
        int totalCal = 0;
        double sumDistance = 0;
        int SumTime = 0;
        int sumCalories = 0;



        for (int i = 0; i < n; i++) {
            int    time     = Integer.parseInt(scanner.nextLine());
            double distance = Double.parseDouble(scanner.nextLine());
            String metric = scanner.nextLine();

            if (metric.equals("m")) {
                distance = distance / 1000;
            }

            totalCal = time * caloriesPerMinute;

            SumTime += time;
            sumDistance += distance;
            sumCalories += totalCal;

        }

        System.out.printf("He ran %.2f km for %d minutes and burned %d calories.", sumDistance, SumTime, sumCalories);

    }
}
