import java.util.*;

public class Lab_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Map<String, Map<String, Double>> store = new TreeMap<>();

        String input = "";

        while (!"Revision".equals(input = scanner.nextLine())) {
            String[] data = input.split(", ");

            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            if (!store.containsKey(shop)) {
                store.put(shop, new LinkedHashMap<>());
                store.get(shop).put(product, price);
            } else {
                store.get(shop).put(product, price);
            }
        }


        store.forEach((shop, products) -> {
            System.out.println(shop + "->");
            products.forEach((producyName, productPrice) -> {
                System.out.println(String.format("Product: %s, Price: %.1f"
                        ,producyName
                        , productPrice
                ));
            });
        });



    }
}
