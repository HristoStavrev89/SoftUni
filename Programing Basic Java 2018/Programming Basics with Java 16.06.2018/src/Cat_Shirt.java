import java.util.Scanner;

public class Cat_Shirt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rakav = Double.parseDouble(scanner.nextLine());
        double frontPart = Double.parseDouble(scanner.nextLine());
        String plat = scanner.nextLine();
        String vratovruzka = scanner.nextLine();

        double shirtSize = rakav * 2 + frontPart * 2;
        double qka = shirtSize + (shirtSize * 0.10);

        double sizeInM = qka / 100;
        double result = 0;


        if ("Linen".equals(plat)) {
            result = sizeInM * 15 + 10;

        } else if ("Cotton".equals(plat)) {
            result = sizeInM * 12 + 10;

        } else if ("Denim".equals(plat)) {
            result = sizeInM * 20 + 10;

        } else if ("Twill".equals(plat)) {
            result = sizeInM * 16 + 10;

        } else {
            result = sizeInM * 11 + 10;

        }

        if (vratovruzka.equals("Yes")) {
            result = result + (result * 0.20);
            System.out.printf("The price of the shirt is: %.2flv.", result);
        } else  {
            System.out.printf("The price of the shirt is: %.2flv.", result);
        }


    }
}
