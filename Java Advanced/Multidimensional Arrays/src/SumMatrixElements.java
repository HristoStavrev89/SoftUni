import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];


        int sumElements = 0;

        for (int row = 0; row < rows; row++) {

            String[] nums = scanner.nextLine().split(", ");

            for (int col = 0; col < nums.length; col++) {

                int current = Integer.parseInt(nums[col]);

                sumElements += current;
                matrix[row][col] = current;
            }

        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumElements);


    }
}
