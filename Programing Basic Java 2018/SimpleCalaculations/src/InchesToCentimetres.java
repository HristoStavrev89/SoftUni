import java.util.Scanner;

public class InchesToCentimetres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inches = Double.parseDouble(scanner.nextLine());
        double inchesToCm = inches*2.54;
        System.out.println(inchesToCm);
    }
}
