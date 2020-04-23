import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r         = Double.parseDouble(scanner.nextLine());
        double PI        = 3.1415926;
        double P         = 2*PI*r;
        double S         = PI*r*r;

        System.out.println("Area = "+S);
        System.out.println("Perimeter = "+P);


    }
}
