import java.io.Console;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int a = Integer.parseInt(console.nextLine());
        int b = Integer.parseInt(console.nextLine());

        int RectangleArea = a*b;

        System.out.println(RectangleArea);
    }
}
