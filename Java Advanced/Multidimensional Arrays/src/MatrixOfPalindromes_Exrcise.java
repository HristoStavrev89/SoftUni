import java.util.Scanner;

public class MatrixOfPalindromes_Exrcise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        char a = 'a';
        char b = 'a';

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                System.out.print(a);
                System.out.print(b);
                System.out.print(a);
                System.out.print(" ");
                b++;
            }
            System.out.println();
            a++;
            b = a;

        }


        }
    }


