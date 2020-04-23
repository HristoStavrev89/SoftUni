package Loops;

import java.util.Scanner;

public class EvenOddSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                oddSum += element;
            } else {
                evenSum += element;
            }

        }
        if (oddSum == evenSum) {
            System.out.println("Yes sum = " + oddSum);
        } else {
            System.out.println("No diff = " + Math.abs(oddSum - evenSum));
        }
    }
}