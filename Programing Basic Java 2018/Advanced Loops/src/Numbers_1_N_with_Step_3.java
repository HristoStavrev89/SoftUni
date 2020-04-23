import java.util.Scanner;

public class Numbers_1_N_with_Step_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("The numbers are: ");

        for (int i = 1; i <= n; i += 3) {
            System.out.println(i);
        }

    }
}
