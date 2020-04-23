import java.util.Scanner;

public class ModulnoDelenie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());


        int result = a % 2;

        System.out.println(result);

    }
}
