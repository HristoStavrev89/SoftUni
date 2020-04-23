import java.math.BigInteger;
import java.util.Scanner;

public class Lab_2_SumBigNumbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = new BigInteger(scanner.nextLine());
        BigInteger b = new BigInteger(scanner.nextLine());
        BigInteger result = a.add(b);

        System.out.println(result);

    }
}
