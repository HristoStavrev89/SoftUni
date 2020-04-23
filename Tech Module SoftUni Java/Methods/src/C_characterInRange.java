import java.util.Scanner;

public class C_characterInRange {
    static void printCharsBetweenTwoOders (char a,char b ) {


        char start = (char) Math.min(a,b);
        for (char i = (char) (start + 1); i < Math.max(a,b); i++) {
            System.out.print(i + " ");
        }

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);

        printCharsBetweenTwoOders(a,b);



    }
}
