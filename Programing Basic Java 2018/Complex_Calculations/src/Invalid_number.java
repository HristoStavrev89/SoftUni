import java.util.Scanner;

public class Invalid_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int num = Integer.parseInt(scanner.nextLine());

        if (num > 200 || num < 100 && !(num == 0)) {
            System.out.println("invalid");
        }
    }
}
