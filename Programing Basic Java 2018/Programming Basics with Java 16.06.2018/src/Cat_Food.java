import java.util.Scanner;

public class Cat_Food {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int group1 = 0;
        int group2 = 0;
        int group3 = 0;
        double foodPrice = 0;

        for (int i = 0; i < n; i++) {
            int food = Integer.parseInt(scanner.nextLine());

            if (food >= 100 && food < 200) {
                group1 ++;
            } else if (food >= 200 && food < 300) {
                group2 ++;
            } else if (food >= 300 && food < 400) {
                group3 ++;
            }

            foodPrice += food;
            }

            double price = (foodPrice / 1000) * 12.45;

        System.out.println("Group 1: " + group1 + " cats.");
        System.out.println("Group 2: " + group2 + " cats.");
        System.out.println("Group 3: " + group3 + " cats.");
        System.out.printf("Price for food per day: %.2f lv.",price);


    }
}
