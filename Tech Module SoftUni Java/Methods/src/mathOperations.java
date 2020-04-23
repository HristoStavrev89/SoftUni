import java.util.Scanner;

public class mathOperations {
    static void addNumbers(int a, int b) {
        System.out.println(a + b);
    }
    static void subttract (int a, int b) {
        System.out.println(a - b);
    }
    static void dublicate (int a, int b) {
        System.out.println(a * b);
    }
    static void divide (int a, int b) {
        System.out.println(a / b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        if (operator.equals("*")) {
            dublicate(a, b);
        } else if (operator.equals("+")) {
            addNumbers(a, b);
        } else if (operator.equals("/")) {
            divide(a, b);
        } else if (operator.equals("-")) {
            subttract(a, b);
        }

    }
}
