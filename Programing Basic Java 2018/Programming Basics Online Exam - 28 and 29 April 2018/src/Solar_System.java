import java.util.Scanner;

public class Solar_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String planet = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int validDays = 0;

        double distance = 0;
        double totalDays = 0;

        if (planet.equals("Mercury")) {
            distance = 2 * 0.61;
            totalDays = 2 * (226 * 0.61) + days;
            validDays += 7;
        } else if (planet.equals("Venus")) {
            distance = 2 * 0.28;
            totalDays = 2 * (226 * 0.28) + days;
            validDays += 14;
        } else if (planet.equals("Mars")) {
            distance = 2 * 0.52;
            totalDays = 2 * (226 * 0.52) + days;
            validDays += 20;
        } else if (planet.equals("Jupiter")) {
            distance = 2 * 4.2;
            totalDays = 2 * (226 * 4.2) + days;
            validDays += 5;
        } else if (planet.equals("Saturn")) {
            distance = 2 * 8.52;
            totalDays = 2 * (226 * 8.52) + days;
            validDays += 3;
        } else if (planet.equals("Uranus")) {
            distance = 2 * 18.21;
            totalDays = 2 * (226 * 18.21) + days;
            validDays += 3;
        } else if (planet.equals("Neptune")) {
            distance = 2 * 29.09;
            totalDays = 2 * (226 * 29.09) + days;
            validDays += 2;
        } else {
            System.out.println("Invalid planet name!");
            return;
        }
        if (validDays >= days) {
            System.out.printf("Distance: %.2f%n",distance);
            System.out.printf("Total number of days: %.2f",totalDays);
        } else if (days > validDays){
            System.out.println("Invalid number of days!");
        }

    }
}
