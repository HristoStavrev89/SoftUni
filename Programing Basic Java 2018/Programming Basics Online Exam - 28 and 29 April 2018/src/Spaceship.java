import java.util.Scanner;

public class Spaceship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double lenght = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double heightAstronauts = Double.parseDouble(scanner.nextLine());


        double spaceShipValue = width * lenght * height;
        double spaceRoom = (heightAstronauts + 0.40) * 2 * 2;
        double astronautsSpace = (int) Math.floor(spaceShipValue / spaceRoom);

        if (astronautsSpace >= 3 && astronautsSpace <= 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.",astronautsSpace);
        } else if (astronautsSpace < 3) {
            System.out.println("The spacecraft is too small.");
        } else {
            System.out.println("The spacecraft is too big.");
        }


    }
}
