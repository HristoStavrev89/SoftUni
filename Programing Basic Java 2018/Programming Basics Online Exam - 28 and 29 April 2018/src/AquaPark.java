import java.util.Scanner;

public class AquaPark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String mont = scanner.nextLine().toLowerCase();
        int h = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        String dayNight = scanner.nextLine().toLowerCase();
        double price = 0.0;
        double oneHour = 0;
        double visit = 0;


        if (mont.equals("march") || mont.equals("april") || mont.equals("may")) {
            if (dayNight.equals("day")) {
                price = 10.50;
            } else {
                price = 8.4;
            }
        } else if (mont.equals("june") || mont.equals("july") || mont.equals("august")) {
            if (dayNight.equals("day")) {
                price = 12.60;
            } else {
                price = 10.20;
            }
        }
        if (people > 4) {
            price = price - (price * 0.1);

        }
        if (h >= 5) {
            price = price - (price * 0.5);
        }
        double total = (price * h) * people;


        System.out.printf("Price per person for one hour: %.2f", price);
        System.out.println();
        System.out.printf("Total cost of the visit: %.2f", total);


    }
}
