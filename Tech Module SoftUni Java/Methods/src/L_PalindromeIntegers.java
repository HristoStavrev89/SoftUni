import java.util.Arrays;
import java.util.Scanner;

public class L_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean stop = true;

        while (stop) {

            int num = Integer.parseInt(scanner.nextLine());
//            if (num != int) {
//                stop = false;
//            } else {
//                palindromeInteger(num);
//            }


        }










        }

        static void palindromeInteger(int number) {
            int[]digits = Integer.toString(number).chars().map(c -> c-'0').toArray();



            int[] fromBack = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            fromBack[fromBack.length - i - 1] = digits[i];
        }

        boolean isItPalindrome = false;

        if (Arrays.equals(digits,fromBack)) {

            isItPalindrome = true;

        } else {

            isItPalindrome = false;
        }

            System.out.println(isItPalindrome);
    }
}
