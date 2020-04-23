import java.util.Scanner;

public class Running_In_The_Park {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int totalMin = 0;
        double totalDistance = 0;

        int calories = 0;
        int caloriesPerMinute = 400 / 20;


        for (int i = 0; i < n; i++) {
            int minPerDay = Integer.parseInt(scanner.nextLine());
            double distancePerDay = Double.parseDouble(scanner.nextLine());
            String unit = scanner.nextLine();

            if (unit.equals("m")) {
                distancePerDay = distancePerDay / 1000;
                totalDistance += distancePerDay;
            } else if (unit.equals("km")) {

                totalDistance += distancePerDay;
            }
            calories = minPerDay * caloriesPerMinute;

            totalMin += minPerDay;


        }
        int totalCalories = calories * n;


        System.out.printf("He ran %.2fkm for %d minutes and burned %d calories.", totalDistance, totalMin, totalCalories);


    }


}
