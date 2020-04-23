import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Second_4_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Double> prices = new LinkedHashMap<>();
        Map<String, Integer> quantities = new LinkedHashMap<>();

        String input = "";

        while (!"buy".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            if (!quantities.containsKey(product) ) {
                quantities.put(product, quantity);
                prices.put(product, quantity * price);

            } else {
                quantities.put(product, quantities.get(product) + quantity);
                prices.put(product, quantities.get(product) * price);

            }
        }


        prices.entrySet().stream()
                .forEach(product -> {
                    System.out.println(String.format("%s -> %.2f",
                            product.getKey(),
                            product.getValue()));
                });




    }
}
