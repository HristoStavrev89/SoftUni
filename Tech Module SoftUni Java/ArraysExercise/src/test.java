import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int with = a % b;

        int without = a / b;

        System.out.printf("Divide with percent: %d%nNormal divide: %d",with,without);
        System.out.println(1784.50/2);

    }
}
