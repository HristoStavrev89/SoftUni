package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engineMap = new HashMap<>();


        //Receving engine models...
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);

            Engine engine = new Engine(power);

            if (data.length == 3) {
                if (Character.isUpperCase(data[2].charAt(0))) {
                    String efficiency = data[2];
                    engine.setEfficiency(efficiency);
                } else {
                    String displacement = data[2];
                    engine.setDisplacement(displacement);
                }
            } else if (data.length == 4) {
                engine.setDisplacement(data[2]);
                engine.setEfficiency(data[3]);

            }
            engineMap.putIfAbsent(model, engine);
        }
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            String engineModel = input[1];

            if (engineMap.containsKey(engineModel)) {
                Car car = new Car( model,engineModel ,engineMap.get(engineModel));

                if (input.length == 3) {
                    if (Character.isAlphabetic(input[2].charAt(0))) {
                        String color = input[2];
                        car.setCarColor(color);
                    } else {
                        String weight = input[2];
                        car.setCarWeight(weight);
                    }
                } else if (input.length == 4) {
                    String weight = input[2];
                    car.setCarWeight(weight);
                    String color = input[3];
                    car.setCarColor(color);
                }


                System.out.println(car.toString());
            }
        }
    }
}
