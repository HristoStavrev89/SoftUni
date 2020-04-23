package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<VehicleCatalogue> trucks = new ArrayList<>();
        List<VehicleCatalogue> cars = new ArrayList<>();

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {
            String[] vehicle = input.split(" ");
            String type = vehicle[0];
            String model = vehicle[1];
            String color = vehicle[2];
            int horsePower = Integer.parseInt(vehicle[3]);

            VehicleCatalogue vehicleCatalogue = new VehicleCatalogue(
                    type,model,color,horsePower);

                if (type.equals("truck")) {
                    trucks.add(vehicleCatalogue);
                } else {
                    cars.add(vehicleCatalogue);
                }



        }

        String inputTwo = "";

        while (!"Close the Catalogue".equals(inputTwo = scanner.nextLine())) {
            String vehicle = inputTwo;

            cars
                    .stream()
                    .filter(v -> v.getModel().equals(vehicle))
                    .forEach(System.out::println);

            trucks
                    .stream()
                    .filter(v -> v.getModel().equals(vehicle))
                    .forEach(System.out::println);

        }

        double totalPowerCars = 0;
        double totalPowerTrucks = 0;

        for (VehicleCatalogue sum : cars) {
            totalPowerCars += sum.getPower();
        }

        for (VehicleCatalogue sum : trucks) {
            totalPowerTrucks += sum.getPower();
        }

        if (cars.size() > 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n",totalPowerCars / cars.size());
        } else {
            totalPowerCars = 0.0;
            System.out.printf("Cars have average horsepower of: %.2f.%n",totalPowerCars);
        }

        if (trucks.size() > 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.",totalPowerTrucks / trucks.size());
        } else {
            totalPowerTrucks = 0.0;
            System.out.printf("Trucks have average horsepower of: %.2f.",totalPowerTrucks);
        }








    }
}
