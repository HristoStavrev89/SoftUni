import java.util.Scanner;

public class Aluminium_Joinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int joinery = Integer.parseInt(scanner.nextLine());
        String size = scanner.nextLine().toLowerCase();
        String delivery = scanner.nextLine();
        double price = 0;
        double discount = 0;
        double discount99 = 0;


        if (joinery < 10) {
            System.out.println("Invalid order");
            return;
        } else if (size.equals("90x130") && joinery > 30 && joinery < 60) {
            price = joinery * 110;
            discount = price - (price * 0.05);
        } else if (size.equals("90x130") && joinery > 60) {
            price = joinery * 110;
            discount = price - (price * 0.08);
        } else if (size.equals("100x150") && joinery > 40 && joinery < 80) {
            price = joinery * 140;
            discount = price - (price * 0.06);
        } else if (size.equals("100x150") && joinery > 80) {
            price = joinery * 140;
            discount = price - (price * 0.10);
        } else if (size.equals("130x180") && joinery > 20 && joinery < 50) {
            price = joinery * 190;
            discount = price - (price * 0.07);
        } else if (size.equals("130x180") && joinery > 50) {
            price = joinery * 190;
            discount = price - (price * 0.12);
        } else if (size.equals("200x300") && joinery > 25 && joinery < 50) {
            price = joinery * 250;
            discount = price - (price * 0.09);
        } else if (size.equals("200x300") && joinery > 50) {
            price = joinery * 250;
            discount = price - (price * 0.14);
        }

        if (delivery.equals("With delivery") && joinery > 99) {
            discount += 60;
            discount99 = discount - (discount * 0.04);
            System.out.printf("%.2f BGN", discount99);
        } else if (delivery.equals("Without delivery ") && joinery > 99) {
            discount99 = discount - (discount * 0.04);
            System.out.printf("%.2f BGN", discount99);
        } else if (delivery.equals("With delivery")) {
            discount += 60;
            System.out.printf("%.2f BGN", discount);
        } else if (delivery.equals("Without delivery")){
            System.out.printf("%.2f BGN", discount);
        }

    }
}
