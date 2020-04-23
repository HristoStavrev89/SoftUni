package April_06_2019_demo.MidExam16Apr2019;

import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        double oneKGFlourPrice = Double.parseDouble(scanner.nextLine());


        double eggsPackPrice = oneKGFlourPrice * 0.75;
        double oneLiterMilkPrice = oneKGFlourPrice +(oneKGFlourPrice * 0.25);
        double quarterMilkPrice = oneLiterMilkPrice / 4;



        double oneCozunacPrice = oneKGFlourPrice + eggsPackPrice + quarterMilkPrice;



        int cozunak = 0;
        int eggs = 0;

        while (budget >= oneCozunacPrice) {

                budget -= oneCozunacPrice;

                cozunak++;
                eggs += 3;

                if (cozunak % 3 == 0) {

                    eggs -= cozunak - 2;

                }






        }

        System.out.println(String.format("You made %d cozonacs! Now you have %d eggs and %.2fBGN left."
        ,cozunak, eggs, budget));




    }
}
