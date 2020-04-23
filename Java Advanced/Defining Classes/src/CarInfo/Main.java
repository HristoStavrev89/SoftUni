package CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            if (data.length == 1) {
                Car car = new Car(data[0]);
                System.out.println(car.carInfo());
            } else {
                String carName = data[0];
                String model = data[1];
                int power = Integer.parseInt(data[2]);
                Car car = new Car(carName, model, power);
                System.out.println(car.carInfo());
            }


        }


    }
}
