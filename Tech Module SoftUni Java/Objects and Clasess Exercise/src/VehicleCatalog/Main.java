package VehicleCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";
        List<Vehicle> vehicles = new ArrayList<>();
        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String type = data[0];
            String model = data[1];
            String color = data[2];
            int horses = Integer.parseInt(data[3]);

            Vehicle vehicle = new Vehicle(type,model,color,horses);

            vehicles.add(vehicle);


        }


        String model = scanner.nextLine();

        while (!"Close the catalogue".equals(model)) {
            String finalModel = model;

            vehicles
                    .stream()
                    .filter(v -> v.getModel().equals(finalModel))
                    .forEach(System.out::println);

            model = scanner.nextLine();
        }
        System.out.println(average(vehicles.stream()
                .filter(v -> v.getType().equals("car"))
                .collect(Collectors.toList())));

        System.out.println(average(vehicles.stream()
                .filter(v -> v.getType().equals("truck"))
                .collect(Collectors.toList())));

    }


    public static double average (List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }
        double sum = 0;

        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getHorsepower();
        }
        return sum / vehicles.size();
    }
}
