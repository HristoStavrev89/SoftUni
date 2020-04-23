import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());


        char[][] firstMatrix = new char[rows][columns];
        char[][] secondMatrix = new char[rows][columns];

        for (int i = 0; i < rows * 2; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            for (int col = 0; col < elements.length; col++) {
                if (i < rows) {
                    firstMatrix[i][col] = elements[col].charAt(0);
                } else {
                    secondMatrix[i - rows][col] = elements[col].charAt(0);
                }

            }


        }

        char[][] resultMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                char firstElement = firstMatrix[row][col];
                char secondElement = secondMatrix[row][col];

                if (firstElement != secondElement) {
                    resultMatrix[row][col] = '*';
                    continue;
                }
                resultMatrix[row][col] = firstElement;
            }
        }


        for (char[] matrix : resultMatrix) {
            System.out.println(Arrays.toString(matrix).replaceAll("[\\]\\[,]",""));
        }



    }
}
