import java.util.Scanner;

public class J_RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rad = Double.parseDouble(scanner.nextLine());

        double deg = rad*180/Math.PI;
        System.out.print(Math.round(deg));
    }
}
