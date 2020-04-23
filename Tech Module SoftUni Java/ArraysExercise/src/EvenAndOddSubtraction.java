import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int even = 0;
        int odd = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                even += numbers[i];
            } else {
                odd += numbers[i];
            }
        }

        System.out.println(even-odd);

//        Write a program that calculates the difference between the sum of the even and the
//        sum of the odd numbers in an array.


    }
}
