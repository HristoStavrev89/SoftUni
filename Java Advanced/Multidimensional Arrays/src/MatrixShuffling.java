import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[r][c];


        for (int row = 0; row < r; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");


        }

        System.out.println();

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");





            if (data[0].equals("swap")) {
                if (data.length == 5) {
                    int takeRow = Integer.parseInt(data[1]);
                    int takeCol = Integer.parseInt(data[2]);

                    int swapRow = Integer.parseInt(data[3]);
                    int swapCol = Integer.parseInt(data[4]);

                    if (takeRow > r || swapRow > r || takeCol > c || swapCol > c) {
                        System.out.println("Invalid input!");
                        continue;
                    }

                    String first = matrix[takeRow][takeCol];
                    String second = matrix[swapRow][swapCol];



                    matrix[swapRow][swapCol] = first;
                    matrix[takeRow][takeCol] = second;

                } else {
                    System.out.println("Invalid input!");
                    continue;
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }


    }
}
