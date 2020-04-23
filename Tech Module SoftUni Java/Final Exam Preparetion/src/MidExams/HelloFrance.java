package MidExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] items = scanner.nextLine().split("\\|");

        double budget = Double.parseDouble(scanner.nextLine());
        double profits = 0.0;

        List<Double> total = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            String[] current = items[i].split("->");

            String subject = current[0];
            double price = Double.parseDouble(current[1]);

            if (price <= 50.00 && subject.equals("Clothes") && budget >= price) {
                budget -= price;
                total.add(price + (price * 0.4));
                profits += (price + (price * 0.4)) - price;

            } else if (price <= 35.00 && subject.equals("Shoes") && budget >= price) {
                budget -= price;
                total.add(price + (price * 0.4));
                profits += (price + (price * 0.4)) - price;

            } else if (price <= 20.50 && subject.equals("Accessories") && budget >= price) {
                budget -= price;
                total.add(price + (price * 0.4));
                profits += (price + (price * 0.4)) - price;
            }

        }


        double totalevent = total.stream().mapToDouble(f -> f.doubleValue()).sum();



        total.stream().forEach(item ->
                System.out.printf("%.2f ",item));



        System.out.println();
        System.out.println(String.format("Profit: %.2f", profits));

        if (totalevent + profits >= 150) {

            System.out.println("Hello, France!");

        } else {
            System.out.println("Time to go.");
        }
    }
}
