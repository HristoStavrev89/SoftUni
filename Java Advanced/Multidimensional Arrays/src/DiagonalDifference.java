import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        int firstDiagonSum = 0;
        int secondDiagonSum = 0;

        for (int row = 0; row < size; row++) {

            int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < size; col++) {
                int current = array[col];
                matrix[row][col] = current;

                // Summing the primary diagonal..
                if (row == col) {
                    firstDiagonSum += current;
                }
            }
        }


        // Summing the secondary diagonal..
        int col = 0;
        for (int row = size - 1; row >= 0; row--) {
            int current = matrix[row][col];
            secondDiagonSum += current;
            col++;
        }


        System.out.println(Math.abs(firstDiagonSum - secondDiagonSum));



    }
}
