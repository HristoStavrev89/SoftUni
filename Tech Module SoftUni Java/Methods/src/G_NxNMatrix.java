import java.util.Scanner;

public class G_NxNMatrix {
    static void printNxNMatrix (int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());

        printNxNMatrix(a);
    }
}
