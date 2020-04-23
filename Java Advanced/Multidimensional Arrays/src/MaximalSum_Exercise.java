import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_Exercise {


    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        int[] rectangle = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rectangle[0];
        int cols = rectangle[1];

        matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }


       int maxSum = -1;
        int rowIndex = -1;
        int collIndex = -1;

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currentSum = getMatrixSum(row, col);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowIndex = row;
                    collIndex = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrixByGivenIndex(rowIndex, collIndex);



    }

    private static void printMatrixByGivenIndex(int rowIndex, int collIndex) {

        if (rowIndex == -1 || collIndex == -1) {
            System.out.println("result not found :(");
        } else {
            int beginRow = rowIndex - 1;
            int beginCol = collIndex - 1;

            for (int r = beginRow; r < beginRow + 3; r++) {
                for (int c = beginCol; c < beginCol + 3; c++) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }


        }
    }

    private static int getMatrixSum(int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        sum += matrix[row - 1][col];
        sum += matrix[row + 1][col];
        sum += matrix[row][col - 1];
        sum += matrix[row][col + 1];
        sum += matrix[row - 1][col - 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row + 1][col - 1];
        sum += matrix[row - 1][col + 1];
        return sum;
    }
}
