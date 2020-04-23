import java.util.Scanner;

public class Travel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double x = Double.parseDouble(scanner.nextLine());
        double v = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        double car = y * 3.6;
        double carSpeed = v + car;

        double truckTime = x / v;
        double carTime = x / carSpeed;

        System.out.printf("The truck arrived after %.0f hours",Math.ceil(truckTime));
        System.out.println();
        System.out.printf("The car arrived after %.0f hours",Math.ceil(carTime));


    }
}
