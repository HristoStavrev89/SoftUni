import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][columns];

        int[][] submatrix = new int[2][2];


        for (int row = 0; row < matrix.length; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < elements.length; col++) {
                int current = elements[col];

                matrix[row][col] = current;

            }
        }

        // to do...



    }
}
