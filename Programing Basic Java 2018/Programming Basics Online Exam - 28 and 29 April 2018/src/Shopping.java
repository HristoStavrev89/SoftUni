import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        double budget = Double.parseDouble(scanner.nextLine());
        int choco = Integer.parseInt(scanner.nextLine());
        double milk = Double.parseDouble(scanner.nextLine());

        double chocoPrice = choco * 0.65;
        double milkPrice  = milk * 2.70;
        double fruit =Math.floor(choco - (choco * 0.35));
        double fruitPrice = fruit * 0.20;
        double total = chocoPrice + milkPrice + fruitPrice;
        double result = 0;

        if (budget >= total) {
            result = budget - total;
            System.out.printf("You got this, %.2f money left!",result);
        } else {
            result = total - budget;
            System.out.printf("Not enough money, you need %.2f more!",result);
        }







    }
}
