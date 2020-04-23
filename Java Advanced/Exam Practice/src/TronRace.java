import java.util.Scanner;

public class TronRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][];


        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().split("");
        }


        int firstPRow = 0;
        int firstPCol = 0;

        int secondPRow = 0;
        int secondPCol = 0;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("f")) {
                    firstPRow = i;
                    firstPCol = j;
                }
                if (matrix[i][j].equals("s")) {
                    secondPRow = i;
                    secondPCol = j;
                }
            }
        }


        boolean dead = false;
        while (dead) {
            String[] input = scanner.nextLine().split("\\s+");

            String firstDirection = input[0];
            String secondDirection = input[1];

            if (firstDirection.equals("down")) {
                goingDown(firstPRow, firstPCol, matrix, "s", "f");
                firstPRow ++;
            }

            if (firstDirection.equals("up")) {
                goingUp(firstPRow, firstPCol, matrix, "s", "f");
                firstPRow--;
            }

            if (firstDirection.equals("left")) {
                goInLeft(firstPRow, secondPCol, matrix, "s", "f");
                firstPCol--;
            }

            if (firstDirection.equals("right")) {
                goInRight(firstPRow, firstPCol, matrix, "s", "f");
                firstPCol++;
            }

            //todo da si dovur6a super skapanoto i opleteno re6enie deto prili4a na manja s grozde!




            if (secondDirection.equals("right")) {
                goInRight(secondPRow, secondPCol, matrix, "f", "s");
                secondPCol++;
            }



            if (secondDirection.equals("down")) {
                goingDown(secondPRow, secondPCol, matrix, "f", "s");
                secondPRow ++;
            }

            if (secondDirection.equals("up")) {
                goingUp(secondPRow, secondPCol, matrix, "f", "s");
                secondPRow--;
            }

            if (secondDirection.equals("left")) {
                goInLeft(secondPRow, secondPCol, matrix, "f", "s");
                secondPCol--;
            }




        }


    }



    private static void printTheMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void goingDown(int row, int col, String[][] matrix, String enemy, String notEnemy) {
        if (row + 1 > matrix.length) {
            row = 0;
        }

        if (!matrix[row + 1][col].equals(enemy)) {
            matrix[row + 1][col] = notEnemy;
        } else {
            matrix[row + 1][col] = "x";
            printTheMatrix(matrix);


        }
    }

    private static void goingUp(int row, int col, String[][] matrix, String enemy, String notEnemy) {

        if (row - 1 < 0) {
            row = matrix.length;
        }

        if (!matrix[row - 1][col].equals(enemy)) {

            matrix[row - 1][col] = notEnemy;
        } else {
            matrix[row][col - 1] = "x";
            printTheMatrix(matrix);

        }
    }

    private static void goInLeft (int row, int col, String[][] matrix, String enemy, String notEnemy) {

        if (col - 1 < 0) {
            col = matrix.length;
        }

        if (!matrix[row][col - 1].equals(enemy)) {
            matrix[row][col - 1] = notEnemy;
        } else {
            matrix[row][col - 1] = "x";
            printTheMatrix(matrix);

        }

    }

    private static void goInRight (int row, int col, String[][] matrix, String enemy, String notEnemy) {

        if (col + 1 > matrix.length) {
            col = 0;
        }

        if (!matrix[row][col + 1].equals(enemy)) {
            matrix[row][col + 1] = notEnemy;
        } else {
            matrix[row][col + 1] = "x";
            printTheMatrix(matrix);

        }

    }

}




