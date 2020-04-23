package April_06_2019_demo.MidExam16Apr2019;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> shops = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            if (data[0].equals("Include")) {
                shops.add(data[1]);
            }


            if (data[0].equals("Visit")) {
                int number = Integer.parseInt(data[2]);
                if (data[1].equals("first") && number < shops.size()) {
                    for (int j = 0; j < number; j++) {
                        shops.remove(0);
                    }
                } else if (data[1].equals("last") && number < shops.size()) {
                    // int lastIndex = shops.size() ;

                    for (int j = 0; j < number; j++) {
                        shops.remove(shops.size() - 1);

                    }
                }
            }


            if (data[0].equals("Place")) {
                String shop = data[1];
                int insert = Integer.parseInt(data[2]);

                if (insert < shops.size()) {
                    shops.add(insert + 1, shop);
                }


            }

            if (data[0].equals("Prefer")) {
                int firstShopIndex = Integer.parseInt(data[1]);
                int secondShopIndex = Integer.parseInt(data[2]);


                if (firstShopIndex < shops.size() && secondShopIndex < shops.size()) {


                    Collections.swap(shops, firstShopIndex, secondShopIndex);

                }


            }


        }

        System.out.println("Shops left:");
        System.out.print(shops.toString().replaceAll("[\\]\\[,]", ""));


    }
}
