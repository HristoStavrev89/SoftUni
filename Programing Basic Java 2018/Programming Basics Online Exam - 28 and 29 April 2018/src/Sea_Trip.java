import java.util.Scanner;

public class Sea_Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       double food = Double.parseDouble(scanner.nextLine());
       double souvenirs = Double.parseDouble(scanner.nextLine());
       double hotel = Double.parseDouble(scanner.nextLine());

       double fuel = 420 / 100 * 7;
       double fuelMoney = fuel * 1.85;

       double threeDays = 3 * food + 3 * souvenirs;

       double firstDay = hotel * 0.9;
       double secondDay = hotel * 0.85;
       double thirdDay = hotel * 0.8;

       double result = fuelMoney + firstDay + secondDay + thirdDay + threeDays + 2.59;

        System.out.printf("Money needed: %.2f",result);





    }
}
