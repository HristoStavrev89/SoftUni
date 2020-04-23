import java.util.Scanner;

public class G_2DRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double a = Math.max(x1,x2) - Math.min(x1,x2);
        double b = Math.max(y1,y2) - Math.min(y2,y1);

        double area = a*b;
        double perimeter = 2 * (a + b);

        System.out.println(area);
        System.out.println(perimeter);



    }
}
