import java.util.Scanner;

public class F_CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());
        System.out.println("Area = " + Math.PI*r*r);
        System.out.println("Perimeter = "+2*Math.PI*r);
    }
}
