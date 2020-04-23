import java.util.Scanner;

public class Styrofoam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double area = Double.parseDouble(scanner.nextLine());
        int windows = Integer.parseInt(scanner.nextLine());
        double inPaket = Double.parseDouble(scanner.nextLine());
        double paket = Double.parseDouble(scanner.nextLine());
        double houseArea = area - windows * 2.4;
        double houseAreaMore = houseArea + (houseArea * 0.10);
        double needPakets = Math.ceil(houseAreaMore / inPaket);
        double paketsPrice = needPakets * paket;
        double left = 0;
        double more = 0;

        if (paketsPrice < budget) {
            left = budget - paketsPrice;
            System.out.printf("Spent: %.2f%n",paketsPrice);
            System.out.printf("Left: %.2f",left);
        } else {
            more = paketsPrice - budget;
            System.out.printf("Need more: %.2f",more);
        }






    }
}
