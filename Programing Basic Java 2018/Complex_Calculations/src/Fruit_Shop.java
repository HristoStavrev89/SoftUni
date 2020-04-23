import java.util.Scanner;

public class Fruit_Shop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine().toLowerCase();
        String day = scanner.nextLine().toLowerCase();
        double quanity = Double.parseDouble(scanner.nextLine());

        double price = -1;

        if (day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") || day.equals("thursday") || day.equals("friday")) {
            if (fruit.equals("banana")) {
                price = quanity * 2.50;
            } else if (fruit.equals("apple")) {
                price = quanity * 1.20;
            } else if (fruit.equals("orange")) {
                price = quanity * 0.85;
            } else if (fruit.equals("grapefruit")) {
                price = quanity * 1.45;
            } else if (fruit.equals("kiwi")) {
                price = quanity * 2.70;
            } else if (fruit.equals("pineapple")) {
                price = quanity * 5.50;
            } else if (fruit.equals("grapes")) {
                price = quanity * 3.85;
            }
        } else if (day.equals("saturday") || day.equals("sunday")) {
            if (fruit.equals("banana")) {
                price = quanity * 2.70;
            } else if (fruit.equals("apple")) {
                price = quanity * 1.25;
            } else if (fruit.equals("orange")) {
                price = quanity * 0.90;
            } else if (fruit.equals("grapefruit")) {
                price = quanity * 1.60;
            } else if (fruit.equals("kiwi")) {
                price = quanity * 3.00;
            } else if (fruit.equals("pineapple")) {
                price = quanity * 5.60;
            } else if (fruit.equals("grapes")) {
                price = quanity * 4.20;
            }
        }
        if (price >= 0) {
            System.out.println(price);
        } else {
            System.out.println("error");
        }
    }
}