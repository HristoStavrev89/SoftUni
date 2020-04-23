import java.util.Arrays;
import java.util.Scanner;

public class topInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e-> Integer.parseInt(e))
                .toArray();

        boolean isBigger = true;


        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[i] <= numbers[j]) {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger) {
                System.out.print(numbers[i] + " ");
            }
            isBigger = true;
        }

//        Write a program to find all the top integers in an array.
//        A top integer is an integer which is bigger than all the elements to its right.

    }
}
