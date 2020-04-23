import java.util.HashSet;
import java.util.Scanner;

public class Lab_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        HashSet<String> parking = new HashSet<>();

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split(",\\s+");

            if (data[0].equals("IN")) {
                parking.add(data[1]);
            } else if (data[0].equals("OUT")) {
                parking.remove(data[1]);
            }

        }

        if (!parking.isEmpty()) {
            parking.stream().forEach(e -> {
                System.out.println(e);
            });
        } else {
            System.out.println("Parking Lot is Empty");
        }


        // alternative
        // System.out.println();
//        System.out.println(parking.isEmpty() ? "Parking Lot is Empty" :
//                String.join(System.lineSeparator(), parking));


    }
}
