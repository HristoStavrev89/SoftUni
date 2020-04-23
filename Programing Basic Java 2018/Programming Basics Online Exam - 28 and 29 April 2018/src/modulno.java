import java.util.Scanner;

public class modulno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int result = a % b;
        int result2 = a / b;
        System.out.println(result);
        System.out.println(result2);

    }
}
