import java.util.Scanner;

public class I_CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double C = Double.parseDouble(scanner.nextLine());
        double F = C * 1.8 + 32;

        System.out.printf("%.2f",F);
    }
}
