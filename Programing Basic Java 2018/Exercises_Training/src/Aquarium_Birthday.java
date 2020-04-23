import java.util.Scanner;

public class Aquarium_Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double s = Double.parseDouble(scanner.nextLine());

        double capacity = a*b*h;
        double liters = capacity * 0.001;
        double procent = s * 0.01;
        double needed = liters * (1-procent);
        System.out.printf("%.3f%n",needed );
    }
}
