import java.util.Scanner;

public class Max_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number > MAX) {
                MAX = number;
            }

        }
        System.out.println(MAX);
    }
}
