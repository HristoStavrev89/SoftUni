import java.util.Scanner;

public class xyRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double a  = Math.abs(x1-x2);
        double b  = Math.abs(y2-y1);

        double S  = a*b;
        double P = 2*a+2*b;

        System.out.println(S);
        System.out.println(P);



    }
}
