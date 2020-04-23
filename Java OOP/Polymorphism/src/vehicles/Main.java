package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Vehicle car = produceVehicle(scanner.nextLine().split("\\s+"));
        Vehicle truck = produceVehicle(scanner.nextLine().split("\\s+"));
        Vehicle bus = produceVehicle(scanner.nextLine().split("\\s+"));


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            if (data[0].equals("Drive")) {
                if (data[1].equals("Car")) {
                    System.out.println(car.drive(Double.parseDouble(data[2])));
                } else if (data[1].equals("Truck")) {
                    System.out.println(truck.drive(Double.parseDouble(data[2])));
                } else if (data[1].equals("Bus")) {
                    System.out.println(bus.drive(Double.parseDouble(data[2])));
                }
            } else if (data[0].equals("Refuel")) {
                if (data[1].equals("Car")) {
                    try {
                        car.refuel(Double.parseDouble(data[2]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else if (data[1].equals("Truck")) {
                    try {
                        truck.refuel(Double.parseDouble(data[2]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (data[1].equals("Bus")) {
                    try {
                        bus.refuel(Double.parseDouble(data[2]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (data[0].equals("DriveEmpty")) {
                try {
                    bus.driveEmpty();
                    System.out.println(bus.drive(Double.parseDouble(data[2])));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }


        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());


    }

    public static Vehicle produceVehicle(String[] data) {
        Vehicle vehicle = null;

        if (data[0].equals("Car")) {
            vehicle = new Car(Double.parseDouble(data[1])
                    , Double.parseDouble(data[2]), Integer.parseInt(data[3]));
        } else if (data[0].equals("Truck")) {
            vehicle = new Truck(Double.parseDouble(data[1])
                    , Double.parseDouble(data[2]), Integer.parseInt(data[3]));
        } else if (data[0].equals("Bus")) {
            vehicle = new Bus(Double.parseDouble(data[1])
                    , Double.parseDouble(data[2]), Integer.parseInt(data[3]));
        }
        return vehicle;
    }
}
