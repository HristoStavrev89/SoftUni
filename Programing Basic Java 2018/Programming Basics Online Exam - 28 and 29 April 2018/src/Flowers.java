import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hrizantemi = Integer.parseInt(scanner.nextLine());
        int rozi = Integer.parseInt(scanner.nextLine());
        int laleta = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();
        double price = 0;
        double all = hrizantemi + rozi + laleta;

        if (season.equals("Spring") || season.equals("Summer")) {
            price = hrizantemi * 2.00 + rozi * 4.10 + laleta * 2.50;
            if (holiday.equals("Y")) {
                price = price + (price * 0.15);
            }
        } else if (season.equals("Winter") || season.equals("Autumn")) {
            price = hrizantemi * 3.75 + rozi * 4.50 + laleta * 4.15;
            if (holiday.equals("Y")) {
                price = price + (price * 0.15);
            }
        }
        if (laleta > 7 && season.equals("Spring")) {
            price = price - (price * 0.05);
        } else if (rozi >= 10 && season.equals("Winter")) {
            price = price - (price * 0.10);
        }
        if (all > 20) {
            price = price - (price * 0.20);
        }
        System.out.printf("%.2f", price + 2);
    }
}
