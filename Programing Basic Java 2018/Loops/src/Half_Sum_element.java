import java.util.Scanner;

public class Half_Sum_element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());
            sum += numbers;
            if (numbers > max) {
                max = numbers;
            }
        }
        sum = sum - max;
        if (sum == max) {
            System.out.println("Yes");
            System.out.println("Sum = " + sum);
        } else {
            int diff = Math.abs(max - sum);
            System.out.println("No");
            System.out.println("Diff = " + diff);
        }


    }
}
