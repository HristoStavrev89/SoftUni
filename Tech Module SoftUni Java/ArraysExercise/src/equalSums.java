import java.util.Arrays;
import java.util.Scanner;

public class equalSums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e-> Integer.parseInt(e))
                .toArray();


        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }

            int rightSum = 0;

            for (int j = i + 1; j < numbers.length ; j++) {
                rightSum += numbers[j];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }




        }

        System.out.println("no");

//        Write a program that determines if there exists an element in the array such
//        that the sum of the elements on its left is equal to the sum of the elements on its right.
//        If there are no elements to the left / right, their sum is considered to be 0. Print the
//        index that satisfies the required condition or “no” if there is no such index.



    }
}
