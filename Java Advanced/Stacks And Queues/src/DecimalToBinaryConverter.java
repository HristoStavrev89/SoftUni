import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int input = Integer.parseInt(scanner.nextLine());
        if (input == 0) {
            System.out.println(0);
        }

        while (input != 0) {
            stack.push(input % 2);
            input /= 2;
        }

        System.out.println(stack.toString().replaceAll("[ \\]\\[\\,]",""));



    }
}
