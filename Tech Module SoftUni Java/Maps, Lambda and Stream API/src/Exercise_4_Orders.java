import java.util.*;

public class Exercise_4_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Integer> products = new LinkedHashMap<>();
        Map<String, Double> productTotal = new LinkedHashMap<>();


        while (!"buy".equals(input = scanner.nextLine())) {
            String data[] = input.split("\\s+");

            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);


            if (!products.containsKey(product) ) {
                products.put(product, quantity);
                productTotal.put(product, quantity * price);

            } else {
                products.put(product, products.get(product) + quantity);
                productTotal.put(product, products.get(product) * price);

            }
        }

        productTotal.entrySet().forEach((e1) -> {
            System.out.println(String.format("%s -> %.2f",
                    e1.getKey(),e1.getValue()));
        });







    }
}
