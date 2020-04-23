import java.util.Scanner;

public class Orders {
    public static void totalSum (String product, double count) {
        if (product.equals("coffee")) {
            count *= 1.50;
        } else if (product.equals("water")) {
            count *= 1.00;
        } else if (product.equals("coke")) {
            count *= 1.40;
        } else if (product.equals("snacks")) {
            count += 2.00;
        } else {
            System.out.println("Wrong input.");
        }

        System.out.printf("%.2f",count);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        totalSum(scanner.nextLine(),Double.parseDouble(scanner.nextLine()));







    }
}
