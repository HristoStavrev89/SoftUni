package wildFarm.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")) {

            String[] animalTokens = input.split("\\s+");

            String[] foodTokens = scanner.nextLine().split("\\s+");

            Animal animal = produceAnimal(animalTokens);

            Food food = produceFood(foodTokens);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            input = scanner.nextLine();
        }

        animals.forEach(a -> {
            System.out.println(a.toString());
        });

    }

    private static Food produceFood(String[] foodTokens) {
        String type = foodTokens[0];

        Food food = null;

        if (type.equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodTokens[1]));
        } else if (type.equals("Meat")) {
            food = new Meat(Integer.parseInt(foodTokens[1]));
        }

        return food;
    }

    private static Animal produceAnimal(String[] tokens) {
        Animal animal = null;

        String type = tokens[0];

        if (type.equals("Mouse")) {
            animal = new Mouse(
                    tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3]);
        } else if (type.equals("Zebra")) {
            animal = new Zebra(
                    tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3]);
        } else if (type.equals("Cat")) {
            animal = new Cat(
                    tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3],
                    tokens[4]);

        } else if (type.equals("Tiger")) {
            animal = new Tiger(
                    tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3]);
        }


        return animal;
    }
}
