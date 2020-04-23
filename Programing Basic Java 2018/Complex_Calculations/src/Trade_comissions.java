import java.util.Scanner;

public class Trade_comissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double s = Double.parseDouble(scanner.nextLine());

        double commissions = -1;

        if (town.equals("Sofia")) {
            if (0 <= s && s <= 500) {
                commissions = 5 / 100.0;
            } else if (500 < s && s <= 1000) {
                commissions = 7 / 100.0;
            } else if (1000 < s && s <= 10000) {
                commissions = 8 / 100.0;
            } else if (s > 10000) {
                commissions = 12 / 100.0;
            }
        }
        else if (town.equals("Varna")) {
            if (0 <= s && s <= 500) {
                commissions = 4.5 / 100.0;
            } else if (500 < s && s <= 1000) {
                commissions = 7.5 / 100.0;
            } else if (1000 < s && s <= 10000) {
                commissions = 10 / 100.0;
            } else if (s > 10000) {
                commissions = 13 / 100.0;
            }
        }
        else if (town.equals("Plovdiv")) {
            if (0 <= s && s <= 500) {
                commissions = 5.5 / 100.0;
            } else if (500 < s && s <= 1000) {
                commissions = 8 / 100.0;
            } else if (1000 < s && s <= 10000) {
                commissions = 12 / 100.0;
            } else if (s > 10000) {
                commissions = 14.5 / 100.0;
            }
        }

        if (commissions > 0 ) {
            double result = s * commissions;
            System.out.printf("%.2f", result);
        } else {
            System.out.println("error");
        }
    }
}
