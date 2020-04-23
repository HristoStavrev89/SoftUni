import java.util.Scanner;

public class E_AddAndSubtract {
    static int sumTwoIntegers (int a, int b) {
        int result = a + b;
        return result;
        }
        static int subtractTwoIntegers (int a, int b) {
        int result = a - b;
        return result;
        }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int sumFirstTwo = sumTwoIntegers(a,b);
        System.out.println(subtractTwoIntegers(sumFirstTwo,c));






    }
}
