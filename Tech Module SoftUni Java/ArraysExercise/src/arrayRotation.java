import java.util.Arrays;
import java.util.Scanner;

public class arrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        int rotations = Integer.parseInt(scanner.nextLine());

        rotations = rotations % numbers.length;

        for (int i = 0; i < rotations; i++) {
            String element = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = element;
        }

        for (String nums : numbers) {
            System.out.print(nums + " ");
        }

       // System.out.println(String.join(" ", numbers));

//        Write a program that receives an array and number of rotations you
//        have to perform (first element goes at the end) Print the resulting array.


    }
}
