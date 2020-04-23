import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(", ");

        for (int i = 0; i < input.length; i++) {
            String current = input[i];
            if (useNameLength(current) && userNameContains(current)) {
                System.out.println(current);
            }
        }
    }
    private static boolean useNameLength (String name) {
        boolean isItValid = true;
        if (name.length() > 16 || name.length() < 3) {
            isItValid = false;
        }
        return isItValid;
    }
    private static boolean userNameContains (String name) {
        boolean isItValid = true;
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetterOrDigit(name.charAt(i)) && name.charAt(i) != '-' && name.charAt(i) != '_') {
                isItValid = false;
            }
        }
        return isItValid;
    }

}
