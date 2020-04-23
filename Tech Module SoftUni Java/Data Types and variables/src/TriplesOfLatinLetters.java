import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (char a = 'a'; a < 'a' + n; a++) {

            for (char b = 'a'; b < 'a' + n; b++) {

                for (char c = 'a'; c < 'a' + n; c++) {

                    System.out.println();
                    System.out.printf("%s%s%s",a,b,c);
                }

            }

        }




    }
}
