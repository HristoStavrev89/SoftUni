import java.util.Arrays;
import java.util.Scanner;

public class equalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[] second = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int sum = 0;

        for (int i = 0; i < first.length; i++) {
            sum+=first[i];
            if (first[i] != second[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index .", i);
                return;
            }
        }
        System.out.println("Arrays are identical. Sum: " + sum);

//        Read two arrays and print on the console whether they are identical or not. Arrays are identical if their elements are equal.
//        If the arrays are identical find the sum of the first one and print on the console following
//        message: "Arrays are identical. Sum: {sum}", otherwise find the first index where the arrays
//        differ and print on the console following message:
//        "Arrays are not identical. Found difference at {index} index."




    }
}
