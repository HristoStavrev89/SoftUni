import java.util.Scanner;

public class Cellphones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        int number = Integer.parseInt(scanner.nextLine());
        String model = scanner.nextLine();
        double price = 0;
        double sum = 0;
        // double modeldiscount = 0;
        // double numberDiscount = 0;

        double levaLeft = 0;
        double moreLeva = 0;

        if (model.equals("Mobifon4e")) {
            price = number * 50.75;
        } else if (model.equals("Gsm4e")) {
            price = number * 20.50;
        } else if (model.equals("Telefon4e")) {
            price = number * 115;
        }
        if (model.equals("Mobifon4e") && number <= 10) {
            sum = price - (price * 0.02);
        } else if (model.equals("Mobifon4e") && number <= 20) {
            sum = price - (price * 0.04);
        } else if (model.equals("Mobifon4e") && number <= 50) {
            sum = price - (price * 0.07);
        } else if (model.equals("Mobifon4e") && number > 50) {
            sum = price - (price * 0.09);
        } else if (model.equals("Gsm4e") && number < 10) {
            sum = price - (price * 0.01);
        } else if (model.equals("Gsm4e") && number <= 20) {
            sum = price - (price * 0.03);
        } else if (model.equals("Gsm4e") && number <= 50) {
            sum = price - (price * 0.06);
        } else if (model.equals("Gsm4e") && number > 50) {
            sum = price - (price * 0.08);
        } else if (model.equals("Telefon4e") && number <= 10) {
            sum = price - (price * 0.03);
        } else if (model.equals("Telefon4e") && number <= 20) {
            sum = price - (price * 0.05);
        } else if (model.equals("Telefon4e") && number <= 50) {
            sum = price - (price * 0.08);
        } else if (model.equals("Telefon4e") && number > 50) {
            sum = price - (price * 0.10);
        }
        if (budget > sum) {
            levaLeft = budget - sum;
            System.out.printf("The company bought all mobile phones. %.2f leva left.",levaLeft);
        } else {
            moreLeva = sum - budget;
            System.out.printf("Not enough money for all mobiles. Company needs %.2f more leva.",moreLeva);
        }

    }
}
