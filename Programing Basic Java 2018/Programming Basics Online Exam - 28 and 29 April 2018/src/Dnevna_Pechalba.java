import java.util.Scanner;

public class Dnevna_Pechalba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double moneyDay = Double.parseDouble(scanner.nextLine());
        double value = Double.parseDouble(scanner.nextLine());

        double montMoney = days * moneyDay;
        double yearMoney = montMoney * 12 + montMoney*2.5;
        double money = yearMoney - (yearMoney * 0.25);
        double sweetMoney = money * value;
        double day = sweetMoney / 365;
        System.out.printf("%.2f",day);









    }
}
