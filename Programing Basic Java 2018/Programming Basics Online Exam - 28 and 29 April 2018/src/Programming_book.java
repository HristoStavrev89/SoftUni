import java.util.Scanner;

public class Programming_book {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pages = Double.parseDouble(scanner.nextLine());
        double covers = Double.parseDouble(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());
        double designer = Double.parseDouble(scanner.nextLine());
        double teamDiscount = Double.parseDouble(scanner.nextLine());

        double percentDiscount = discount / 100;
        double teamPay = teamDiscount / 100;

        double pricePages = pages * 899 + covers * 2;

        double discounting = pricePages * (1 - percentDiscount);

        double design = discounting + designer;

        double result = design * (1 - teamPay);

        System.out.printf("Avtonom should pay %.2f BGN.",result);
    }
}
