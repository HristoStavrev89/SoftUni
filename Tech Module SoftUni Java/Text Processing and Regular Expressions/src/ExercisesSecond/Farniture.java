package ExercisesSecond;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Farniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String extractor = "(?<brackets>[>]{2}(?<name>[\\w]+)[<]{2})(?<price>[\\d]+\\.*\\d+)!(?<quantity>[\\d]+)";
        String input = "";
        List<String> farniture = new ArrayList<>();
        double priceTotal = 0;

        while (!"Purchase".equals(input = scanner.nextLine())) {
            String data = input;

            Pattern pattern = Pattern.compile(extractor);
            Matcher matcher = pattern.matcher(data);

            while (matcher.find()) {
                String name = matcher.group("name");
                String price = matcher.group("price");
                String quan = matcher.group("quantity");

                double test = Double.parseDouble(price);
                int quantity = Integer.parseInt(quan);

                farniture.add(name);
                priceTotal += test * quantity;
            }

        }
        System.out.println("Bought furniture:");
        for (String name : farniture) {
            System.out.println(name);
        }
        System.out.printf("Total money spend: %.2f",priceTotal);
    }
}
