import java.util.Scanner;

public class MidExamFebruaryGroup2Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());

        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterDayPerson = Double.parseDouble(scanner.nextLine());
        double foodDayPerson = Double.parseDouble(scanner.nextLine());



        double currentWater = waterDayPerson * days * players;
        double currentFood = foodDayPerson * days * players;
        double currentEnergy = groupEnergy;


        for (int i = 1; i <= days; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            currentEnergy -= energyLoss;

            if (currentEnergy > 0) {
                if (i % 2 == 0) {
                    currentEnergy = currentEnergy + (currentEnergy * 0.05);
                    currentWater = currentWater - (currentWater * 0.3);

                }
                if (i % 3 == 0) {
                    currentFood = currentFood / players;
                    currentEnergy *= 1.10;
                }



            } else {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",currentFood,currentWater);
                return;
            }


        }


        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!",currentEnergy);


    }
}
