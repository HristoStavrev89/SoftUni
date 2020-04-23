import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class fromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        }



    }
}
