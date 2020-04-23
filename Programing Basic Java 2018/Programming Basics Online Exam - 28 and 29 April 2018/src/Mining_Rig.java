import java.util.Scanner;

public class Mining_Rig {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);

        int video = Integer.parseInt(scanner.nextLine());
        int converter = Integer.parseInt(scanner.nextLine());

        // Консумирана мощност от 1 карта ЗА ЕДИН ДЕН.
        double videoW = Double.parseDouble(scanner.nextLine());

        // Печалба от 1 карта за 1 ден.
        double incomeVideo = Double.parseDouble(scanner.nextLine());


        int totalPrice = (video * 13) + (converter * 13) + 1000;

        double oneCardIncomingDay = incomeVideo - videoW;
        double totalIncoming = oneCardIncomingDay * 13;
        double moneyBack = totalPrice / totalIncoming;

        System.out.println(totalPrice);
        System.out.println((int)Math.ceil(moneyBack));









    }
}
