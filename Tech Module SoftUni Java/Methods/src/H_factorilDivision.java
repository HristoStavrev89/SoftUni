import java.util.Scanner;

public class H_factorilDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        double divideNum = Double.parseDouble(scanner.nextLine());

        double result = findFactorialNumber(num) / findFactorialNumber(divideNum);

        System.out.printf("%.2f",result);

    }

    private static double findFactorialNumber(double num) {
        double factorial = 1;
        for (int i = 1; i <= num; ++i) {
            factorial *= i;
        }
        return factorial;
    }
}
