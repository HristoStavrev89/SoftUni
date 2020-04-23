package Loops;

import java.util.Scanner;

public class Left_and_right_sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int leftSum = 0;

        for (int i = 0; n > i; i++) {
            int currentSum = Integer.parseInt(scanner.nextLine());
            leftSum += currentSum;
        }

        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            int Rsum = Integer.parseInt(scanner.nextLine());
            rightSum += Rsum;
        }
        if (leftSum == rightSum) {
            System.out.println("Yes, sum = " + leftSum);
        } else {
            System.out.println("No, diff = " + Math.abs(rightSum - leftSum) );
        }
    }
}