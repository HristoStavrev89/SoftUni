package ExercisesSecond;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";
        String customerExtractor = "(.*)[%](?<name>[A-Z][a-z]+)[%](.*)<(?<product>[^<>]+)>(.*)[|](?<count>[\\d]+)[|](.*?)(?<price>[\\d.]+)[$]";
        Pattern pattern = Pattern.compile(customerExtractor);

        double totalIncome = 0;

        Map<String, Double> customers = new LinkedHashMap<>();
        while (!"end of shift".equals(input = scanner.nextLine())) {
            String data = input;

            String customer = "";
            String product = "";
            int quantity = 0;
            double price = 0;

            Matcher matcher = pattern.matcher(data);

            while (matcher.find()) {
                customer = matcher.group("name");
                product = matcher.group("product");
                quantity = Integer.parseInt(matcher.group("count"));
                price = Double.parseDouble(matcher.group("price"));
            }

            double amountPrice = quantity * price;
            totalIncome += amountPrice;

            if (!customers.containsKey(customer)) {
                if (amountPrice > 0 || customer.length() > 0) {
                    customers.put(customer, amountPrice);
                }
            } else {
                customers.put(customer, customers.get(customer) + amountPrice);
            }

            if (amountPrice > 0) {
                System.out.println(String.format("%s: %s - %.2f", customer,
                        product,
                        amountPrice));
            }

        }



        System.out.printf("Total income: %.2f",totalIncome);






    }
}
