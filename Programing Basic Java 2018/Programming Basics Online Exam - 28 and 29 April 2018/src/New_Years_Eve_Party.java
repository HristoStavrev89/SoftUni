import java.util.Scanner;

public class New_Years_Eve_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int gests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        int kuvert = gests * 20;
        int ostava6ti = 0;
        double foerwerk = 0;
        double darenie = 0;


        if (kuvert < budget) {
            ostava6ti = budget - kuvert;
            foerwerk = ostava6ti - (ostava6ti * 0.4);
            darenie = ostava6ti - foerwerk;

            System.out.printf("Yes! %.0f lv are for fireworks and %.0f lv are for donation.",darenie,foerwerk);

        } else if (kuvert > budget){
            ostava6ti = kuvert - budget;
            System.out.printf("They won't have enough money to pay the covert. They will need %d lv more.", ostava6ti);
        }


    }
}
