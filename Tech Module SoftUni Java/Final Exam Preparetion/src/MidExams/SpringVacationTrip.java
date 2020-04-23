package MidExams;

import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int groupPeople = Integer.parseInt(scanner.nextLine());
        double fuelPriceKM = Double.parseDouble(scanner.nextLine());
        double foodPerPersonDay = Double.parseDouble(scanner.nextLine());
        double roomPricePerson = Double.parseDouble(scanner.nextLine());


        double foodExpansesDay = foodPerPersonDay * groupPeople;
        double hotelPriceAll = groupPeople * roomPricePerson;
        double currentExpenses = foodExpansesDay + hotelPriceAll;


        double total = 0;
        for (int i = 0; i < days; i++) {

            int distanceKm = Integer.parseInt(scanner.nextLine());
            double fuelPricePerDay = fuelPriceKM * distanceKm;

            total += fuelPricePerDay + currentExpenses;
            if (i % 3 == 0) {
                total += (total * 0.4);
            } else if (i % 5 == 0) {
                total += (total * 0.4);
            } else if (i % 7 == 0) {
                budget += (total / groupPeople);
            }

        }

        if (budget > total) {
            System.out.println(budget - total);
        } else if (total > budget) {
            System.out.println(total - budget);
        }







    }
}
