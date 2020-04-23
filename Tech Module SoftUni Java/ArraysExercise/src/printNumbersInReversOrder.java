import java.util.Scanner;

public class printNumbersInReversOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = n - 1; i >= 0 ; i--) {
            System.out.print(numbers[i] + " ");

        }


      //  Read n numbers and print them in reverse order.





    }
}
