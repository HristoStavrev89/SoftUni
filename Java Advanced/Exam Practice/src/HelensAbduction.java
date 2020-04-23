import java.util.Arrays;
import java.util.Scanner;

public class HelensAbduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int energy = Integer.parseInt(scanner.nextLine());


        int n = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[n][];

        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().split("");
        }



        //Helen location
        int helenRow = 0;
        int helenCow = 0;

        //Paris location
        int parisRow = 0;
        int parisCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j].equals("H")) {
                    helenRow = i;
                    helenCow = j;
                }
                if (field[i][j].equals("P")) {
                    parisRow = i;
                    parisCol = j;
                }
            }
        }

        while (energy > 0) {
            String[] command = scanner.nextLine().split("\\s+");

            String direction = command[0];
            int r = Integer.parseInt(command[1]);
            int c = Integer.parseInt(command[2]);

            //Enemy spawn
            field[r][c] = "S";




            if (direction.equals("up")) {
                if (parisRow - 1 < 0) {
                    energy--;
                }

                else {
                    if (field[parisRow - 1][parisCol].equals("S")) {
                        energy -=2;
                    }
                    field[parisRow - 1][parisCol] = "P";
                    field[parisRow][parisCol] = "-";
                    energy--;
                    parisRow -= 1;

                }
            } else if (direction.equals("down")) {
                if (parisRow + 1 > field.length - 1) {
                    energy--;
                } else {
                    if (field[parisRow + 1][parisCol].equals("S")){
                        energy -= 2;
                    }
                    energy--;
                    field[parisRow + 1][parisCol] = "P";
                    field[parisRow][parisCol] = "-";
                    parisRow += 1;

                }
            } else if (direction.equals("left")) {
                if (parisCol - 1 < 0) {
                    energy--;
                } else {
                    if (field[parisRow][parisCol - 1].equals("S")) {
                        energy -= 2;
                    }
                    energy--;
                    field[parisRow][parisCol - 1] = "P";
                    field[parisRow][parisCol] = "-";
                    parisCol -= 1;
                }
            } else if (direction.equals("right")) {
                if (parisCol + 1 > field.length - 1) {
                    energy--;
                } else {
                    if (field[parisRow][parisCol + 1].equals("S")) {
                        energy -= 2;
                    }
                    energy--;
                    field[parisRow][parisCol + 1] = "P";
                    field[parisRow][parisCol] = "-";
                    parisCol += 1;
                }
            }

            // S
//            if (parisRow == r && parisCol == c) {
//                energy -= 2;
//            }
            if (parisRow == helenRow && parisCol == helenCow) {
                System.out.print("Paris has successfully abducted Helen! ");
                System.out.println("Energy left: " + energy);
                field[parisRow][parisCol] = "-";
                field[helenRow][helenCow] = "-";
                for (int i = 0; i < field.length; i++) {
                    Arrays.stream(field[i]).forEach(System.out::print);
                    System.out.println();
                }
                break;
            }



        }
        if (energy < 0 || energy == 0) {
            System.out.println(String.format("Paris died at %d;%d.", parisRow, parisCol));
            field[parisRow][parisCol] = "X";
            for (int i = 0; i < field.length; i++) {
                Arrays.stream(field[i]).forEach(System.out::print);
                System.out.println();
            }
        }
    }
}