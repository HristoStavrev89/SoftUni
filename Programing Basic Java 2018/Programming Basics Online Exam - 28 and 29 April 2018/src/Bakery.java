import java.util.Scanner;

public class Bakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int testoGramm = Integer.parseInt(scanner.nextLine());
        int hlebnoGramm = Integer.parseInt(scanner.nextLine());
        double hlebnoPrice = Double.parseDouble(scanner.nextLine());
        int hlebniSell = Integer.parseInt(scanner.nextLine());
        int sladkishSell = Integer.parseInt(scanner.nextLine());
       // double testoKg = testoGramm / 1000;


        double dnevniPrihodi = hlebniSell * hlebnoPrice;
        double testoNeed = hlebniSell * hlebnoGramm;
        //double testoNeedKg = testoNeed / 1000;
        double sladkishPrice = hlebnoPrice + (hlebnoPrice * 0.25);
        double sladkishGramm = hlebnoGramm - (hlebnoGramm * 0.20);
        double testaSladkish = sladkishSell * sladkishGramm;
        double noshniPrihodi = sladkishSell * sladkishPrice;
        double totalRazhodi = (testoGramm + testoNeed) / 250;
        double zaplata = (dnevniPrihodi + noshniPrihodi) - totalRazhodi;
        double usedTesto = testoNeed + testaSladkish;

        System.out.printf("Pure income: %.2f lv.",zaplata);
        System.out.println();
        System.out.printf("Dough used: %.0f g.",usedTesto);







    }
}
