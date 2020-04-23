import java.util.Scanner;

public class Sushi_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sushi = scanner.nextLine();
        String resturant = scanner.nextLine();
        int portions = Integer.parseInt(scanner.nextLine());
        String order = scanner.nextLine();
        double price = 0;


        if (sushi.equals("sashimi")) {
            switch (resturant) {
                case "Sushi Zone":
                    price = 4.99;
                    break;
                case "Sushi Time":
                    price = 5.49;
                    break;
                case "Sushi Bar":
                    price = 5.25;
                    break;
                case "Asian Pub":
                    price = 4.50;
                    break;
                default:
                    System.out.println(resturant + " is invalid restaurant!");
                    break;
            }
        }


        if (sushi.equals("maki")) {
            switch (resturant) {
                case "Sushi Zone":
                    price = 5.29;
                    break;
                case "Sushi Time":
                    price = 4.69;
                    break;
                case "Sushi Bar":
                    price = 5.55;
                    break;
                case "Asian Pub":
                    price = 4.80;
                    break;
                default:
                    System.out.println(resturant + " is invalid restaurant!");

                    break;
            }
        }


        if (sushi.equals("uramaki")) {
            switch (resturant) {
                case "Sushi Zone":
                    price = 5.99;
                    break;
                case "Sushi Time":
                    price = 4.49;
                    break;
                case "Sushi Bar":
                    price = 6.25;
                    break;
                case "Asian Pub":
                    price = 5.50;
                    break;
                default:
                    System.out.println(resturant + " is invalid restaurant!");
                    break;
            }
        }


        if (sushi.equals("temaki")) {
            if ("Sushi Zone".equals(resturant)) {
                price = 4.29;

            } else if ("Sushi Time".equals(resturant)) {
                price = 5.19;

            } else if ("Sushi Bar".equals(resturant)) {
                price = 4.75;

            } else if ("Asian Pub".equals(resturant)) {
                price = 5.50;

            } else {
                System.out.println(resturant + " is invalid restaurant!");

            }
        }
        double totalPrice = price * portions;

        if (order.equals("Y")) {
            double priceY = totalPrice + (totalPrice * 0.20);
            int priceYCeiil = (int) Math.ceil(priceY);
            System.out.printf("Total price: %d lv.",priceYCeiil);
        }

        else if (order.equals("N")) {
            int priceN = (int) Math.ceil(totalPrice);
            System.out.printf("Total price: %d lv.",priceN);
        }


    }
}
