package pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] pizzaInput = scanner.nextLine().split("\\s+");
        Pizza pizza = new Pizza(pizzaInput[1], Integer.parseInt(pizzaInput[2]));

        String[] doughInput = scanner.nextLine().split("\\s+");

        Dough dough = new Dough(doughInput[1], doughInput[2], Double.parseDouble(doughInput[3]));

        pizza.setDough(dough);

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] toppingInput = input.split("\\s+");
            Topping topping = new Topping(toppingInput[1], Double.parseDouble(toppingInput[2]));
            pizza.addTopping(topping);
        }


        System.out.println(String.format("%s - %.2f"
        ,pizza.getName()
        ,pizza.getOverallCalories()));


    }
}
