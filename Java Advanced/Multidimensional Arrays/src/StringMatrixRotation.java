import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String rotate = scanner.nextLine();
        String input = "";
        String data = "";

        while (!"END".equals(input = scanner.nextLine())) {
            data += input + " ";
        }

        String[] text = data.split("\\s+");

        int n = text.length;


        int maxLength = 0;


        for (int i = 0; i < text.length; i++) {
            if (text[i].length() > maxLength) {
                maxLength = text[i].length();
            }
        }
        char[][] matrix = new char[text.length][maxLength];


        for (int row = 0; row < n; row++) {
            String word = text[row];


            for (int col = 0; col < maxLength; col++) {

                if (col >= word.length()) {
                    char space = ' ';
                    matrix[row][col] = space;
                } else {
                    char current = word.charAt(col);

                    matrix[row][col] = current;
                }

            }

        }


        int index1 = rotate.indexOf("(");
        int index2 = rotate.indexOf(")");
        String getNum = rotate.substring(index1 + 1, index2);
        int degrees = Integer.parseInt(getNum);
        int rotation = degrees % 360;




        // 90
        if (rotation == 90) {
            for (int col = 0; col < maxLength; col++) {
                for (int row = n - 1; row >= 0; row--) {

                    char element = matrix[row][col];
                    System.out.print(element);

                }
                System.out.println();
            }
        } else if (rotation == 0) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < maxLength; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotation == 180) {

            for (int row = n - 1; row >= 0; row--) {
                for (int col = maxLength - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotation == 270) {
            for (int col = maxLength - 1; col >= 0; col--) {
                for (int row = 0; row < n; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }

    }
}
