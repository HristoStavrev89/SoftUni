import java.util.Arrays;
import java.util.Scanner;

public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][];

        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = scanner.nextLine().split("");
        }


        //Stephen location
        int rowStephen = 0;
        int colStephen = 0;

        //First black hole
        int firstHoleRow = 0;
        int firstHoleCol = 0;

        //Second black hole
        int secondHoleRow = 0;
        int secondHoleCol = 0;

        boolean firstHole = true;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("S")) {
                    rowStephen = i;
                    colStephen = j;
                }
                if (matrix[i][j].equals("O") && firstHole) {
                    firstHoleRow = i;
                    firstHoleCol = j;
                    firstHole = false;
                }
                if (matrix[i][j].equals("O") && i != firstHoleRow && j != firstHoleCol) {
                    secondHoleRow = i;
                    secondHoleCol = j;
                }
            }
        }


        int starPower = 0;


        while (starPower < 50) {
            String command = scanner.nextLine();

            if (command.equals("right")) {
                if (colStephen + 1 > matrix.length - 1) {
                    //todo print the matrix, stop the program
                    matrix[rowStephen][colStephen] = "-";
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + starPower);
                    printTheMAtrix(matrix);
                    return;
                } else if (matrix[rowStephen][colStephen + 1].equals("O")) {
                    //todo move throught the black holes
                    matrix[rowStephen][colStephen] = "-";

                    if (rowStephen == firstHoleRow && colStephen + 1 == firstHoleCol) {
                        matrix[rowStephen][colStephen + 1] = "-";
                        rowStephen = secondHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";
                        //todo delete the hole
                    } else {
                        rowStephen = firstHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";
                    }

                } else if (matrix[rowStephen][colStephen + 1].equals("-")) {
                    matrix[rowStephen][colStephen] = "-";
                    colStephen += 1;
                } else {
                    int starValue = Integer.parseInt(matrix[rowStephen][colStephen + 1]);
                    matrix[rowStephen][colStephen + 1] = "S";
                    matrix[rowStephen][colStephen] = "-";
                    starPower += starValue;
                    colStephen += 1;
                }

            } else if (command.equals("left")) {
                if (colStephen - 1 < 0) {
                    //todo print the matrix, stop the program
                    matrix[rowStephen][colStephen] = "-";
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + starPower);
                    printTheMAtrix(matrix);
                    return;
                } else if (matrix[rowStephen][colStephen - 1].equals("O")) {
                    //todo move throught the black holes
                    matrix[rowStephen][colStephen] = "-";

                    if (rowStephen == firstHoleRow && colStephen - 1 == firstHoleCol) {
                        matrix[rowStephen][colStephen - 1] = "-";
                        rowStephen = secondHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";
                        //todo delete the hole
                    } else {
                        rowStephen = firstHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";
                    }

                } else if (matrix[rowStephen][colStephen - 1].equals("-")) {
                    matrix[rowStephen][colStephen] = "-";
                    colStephen -= 1;
                } else {
                    int starValue = Integer.parseInt(matrix[rowStephen][colStephen - 1]);
                    matrix[rowStephen][colStephen - 1] = "S";
                    matrix[rowStephen][colStephen] = "-";
                    starPower += starValue;
                    colStephen -= 1;
                }
            } else if (command.equals("up")) {
                if (rowStephen - 1 < 0) {
                    matrix[rowStephen][colStephen] = "-";
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + starPower);
                    printTheMAtrix(matrix);
                    return;
                } else if (matrix[rowStephen - 1][colStephen].equals("O")) {

                    matrix[rowStephen][colStephen] = "-";
                    if (rowStephen - 1 == firstHoleRow && colStephen == firstHoleCol) {
                        matrix[rowStephen - 1][colStephen] = "-";
                        rowStephen = secondHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";

                    } else {
                        rowStephen = firstHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";
                    }
                } else if (matrix[rowStephen - 1][colStephen].equals("-")) {
                    matrix[rowStephen][colStephen] = "-";
                    rowStephen -= 1;
                } else {
                    int starValue = Integer.parseInt(matrix[rowStephen - 1][colStephen]);
                    matrix[rowStephen - 1][colStephen] = "S";
                    matrix[rowStephen][colStephen] = "-";
                    starPower += starValue;
                    rowStephen -= 1;
                }
            } else if (command.equals("down")) {
                if (rowStephen + 1 > matrix.length - 1) {
                    matrix[rowStephen][colStephen] = "-";
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + starPower);
                    printTheMAtrix(matrix);
                    return;
                } else if (matrix[rowStephen + 1][colStephen].equals("O")) {
                    matrix[rowStephen][colStephen] = "-";
                    if (rowStephen + 1 == firstHoleRow && colStephen == firstHoleCol) {
                        matrix[rowStephen + 1][colStephen] = "-";
                        rowStephen = secondHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";
                        //todo delete the hole
                    } else {
                        rowStephen = firstHoleRow;
                        colStephen = secondHoleCol;
                        matrix[rowStephen][colStephen] = "S";
                    }
                } else if (matrix[rowStephen + 1][colStephen].equals("-")) {
                    matrix[rowStephen][colStephen] = "-";
                    rowStephen += 1;
                } else {
                    int starValue = Integer.parseInt(matrix[rowStephen + 1][colStephen]);
                    matrix[rowStephen + 1][colStephen] = "S";
                    matrix[rowStephen][colStephen] = "-";
                    starPower += starValue;
                    rowStephen += 1;
                }
            }


        }

        System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        System.out.println("Star power collected: " + starPower);
        printTheMAtrix(matrix);


    }

    private static void printTheMAtrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
