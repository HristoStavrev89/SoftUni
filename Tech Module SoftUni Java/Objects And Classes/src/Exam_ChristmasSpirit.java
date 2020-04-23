import java.util.Scanner;

public class Exam_ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int christmasSpirit = 0;
        int totalCost = 0;

        int ornamentSet = 2;
        int treeSkirt = 5;
        int treeGarlands = 3;
        int treeLights = 15;

        for (int i = 1; i <= days; i++) {
            if (i % 11 == 0) {
                quantity += 2;
            }
            if (i % 2 == 0) {
                totalCost += ornamentSet * quantity;
                christmasSpirit += 5;
            }
            if (i % 3 == 0) {
                totalCost += treeSkirt * quantity;
                totalCost += treeGarlands * quantity;
                christmasSpirit += 13;
            }
            if (i % 5 == 0) {
                totalCost += treeLights * quantity;
                christmasSpirit += 17;
            }
            if (i % 3 == 0 && i % 5 == 0) {
                christmasSpirit += 30;
            }
            if (i % 10 == 0) {
                christmasSpirit -= 20;
                totalCost += treeSkirt + treeGarlands + treeLights;
            }


            if (i == days && i % 10 == 0) {
                christmasSpirit -= 30;
            }

        }

        System.out.println("Total cost: " + totalCost);
        System.out.println("Total spirit: " + christmasSpirit);

    }
}
