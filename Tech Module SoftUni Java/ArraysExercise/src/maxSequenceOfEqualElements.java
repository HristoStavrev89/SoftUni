import java.util.Arrays;
import java.util.Scanner;

public class maxSequenceOfEqualElements {
    public static void main(String[] args) {
//        Write a program that finds the longest sequence of equal elements in an array of integers.
//        If several longest sequences exist, print the leftmost one.
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
        .split(" "))
                .mapToInt(e-> Integer.parseInt(e))
                .toArray();

        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            int currentCount = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == (numbers[j])) {
                    currentCount++;
                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                        maxIndex = i;
                    }
                }
                else {
                    break;
                }
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(numbers[i + maxIndex] + " ");
        }



    }
}
