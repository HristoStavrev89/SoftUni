import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int divideWithPercent = a % b;

        int divideWithoutPercent = a / b;

        System.out.println("with percent % "+ divideWithPercent);
        System.out.println("normal " + divideWithoutPercent);


    }
}
