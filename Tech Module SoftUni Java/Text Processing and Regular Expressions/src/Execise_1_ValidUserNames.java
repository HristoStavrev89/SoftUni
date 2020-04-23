import java.util.Scanner;

public class Execise_1_ValidUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] names = scanner.nextLine().split(", ");

        for (String name : names) {
            if (validateNames(name)) {
                System.out.println(name);
            }
        }



    }
    private static boolean validateNames (String name) {
        if (name.length() > 16 || name.length() < 3) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetterOrDigit(name.charAt(i))
            && name.charAt(i) != '-'
            && name.charAt(i) != '_') {
                return false;
            }
        }
        return true;

    }
}
