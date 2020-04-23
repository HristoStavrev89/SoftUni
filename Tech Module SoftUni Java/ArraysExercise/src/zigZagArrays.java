import java.util.Arrays;
import java.util.Scanner;

public class zigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] one = new int[n];
        int[] two = new int[n];


        for (int i = 0; i < n; i++) {
            String[] nums = scanner.nextLine().split(" ");

            if (i % 2 == 0) {
                one[i] = Integer.parseInt(nums[0]);
                two[i] = Integer.parseInt(nums[1]);
            } else {
                one[i] = Integer.parseInt(nums[1]);
                two[i] = Integer.parseInt(nums[0]);
            }
        }

        for (int first : one) {
            System.out.print(first + " ");
        }
        System.out.println();
        for (int second : two) {
            System.out.print(second + " ");
        }

//        Zig-Zag Arrays
//        Write a program which creates 2 arrays.You will be given an integer n.
//                On the next n lines you get 2 integers.
//                Form 2 arrays as shown below.



    }
}
