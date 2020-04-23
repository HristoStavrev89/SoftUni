package RawData;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Truck> stats = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String model = data[0];
            int speed = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            //Tires pressure/age
            double tire1Pressuere = Double.parseDouble(data[5]);
            int tire1age = Integer.parseInt(data[6]);

            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2age = Integer.parseInt(data[8]);

            double tire3Pressuere = Double.parseDouble(data[9]);
            int tire3age = Integer.parseInt(data[10]);

            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4age = Integer.parseInt(data[12]);

            String truckModel = model;

            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tires = new Tires(tire1Pressuere, tire1age, tire2Pressure,
                    tire2age, tire3Pressuere, tire3age, tire4Pressure, tire4age);

            Truck truck = new Truck(engine, cargo, tires);

            stats.putIfAbsent(model, truck);
        }

        String command = scanner.nextLine();




            for (Map.Entry<String, Truck> stringTruckEntry : stats.entrySet()) {
                if (command.equals("fragile")) {
                    if (stringTruckEntry.getValue().getCargo().getCargoType().equals(command)) {
                        if (stringTruckEntry.getValue().getTires().getTire1Pressure() < 1
                                || stringTruckEntry.getValue().getTires().getTire2Pressure() < 1
                                || stringTruckEntry.getValue().getTires().getTire3Pressure() < 1
                                || stringTruckEntry.getValue().getTires().getTire4Pressure() < 1) {
                            System.out.println(stringTruckEntry.getKey());
                        }
                    }
                } else if (command.equals("flamable")) {
                    if (stringTruckEntry.getValue().getCargo().getCargoType().equals(command)) {
                        if (stringTruckEntry.getValue().getEngine().getPower() > 250) {
                            System.out.println(stringTruckEntry.getKey());
                        }
                    }
                }
            }

    }
}
