import java.util.Scanner;

public class HearthStone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int restTime = Integer.parseInt(scanner.nextLine());
        double pricePaket = Double.parseDouble(scanner.nextLine());
        double adventure = Double.parseDouble(scanner.nextLine());
        double coffeePrice = Double.parseDouble(scanner.nextLine());


        double pause = restTime - 5;
        double buyngPacks = 3 * 2;
        double buyingAdventures = 2 * 2;
        double rest = pause - (buyngPacks + buyingAdventures);
        double packsMoney = 3 * pricePaket;
        double adventuresMoney = 2 * adventure;
        double total = adventuresMoney + packsMoney + coffeePrice;

        System.out.printf("%.2f",total);
        System.out.println();
        System.out.printf("%.0f",rest);



    }
}
