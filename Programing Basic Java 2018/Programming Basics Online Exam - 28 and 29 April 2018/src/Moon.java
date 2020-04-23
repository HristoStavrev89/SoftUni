import java.util.Scanner;

public class Moon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double speed = Double.parseDouble(scanner.nextLine());
        double fuel = Double.parseDouble(scanner.nextLine());
        double totalDistance = 384400 * 2;
        double travelTime = Math.ceil(totalDistance / speed);
        double totalTime = travelTime + 3;
        double totalFuel = (fuel * totalDistance) / 100;

        System.out.println((int)totalTime);
        System.out.println((int)totalFuel);





    }
}
