import java.util.Scanner;

public class D_passwordValidator {
    static boolean atLeastTwoDigits (String a) {
        char[] letter = a.toCharArray();
        int digits = 0;
        boolean isValid = true;
        for (int i = 0; i < letter.length; i++) {

            if ((letter[i] >= 48 && letter[i] <= 57)) {
                digits++;
            }
            }
            if (digits < 2) {
                System.out.println("Password must have at least 2 digits");
                isValid = false;

            }
            return isValid;
    }
    static boolean passwordLength(String a) {
        boolean isItValid = true;

        if (a.length() < 6 || a.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isItValid = false;
        }
        return isItValid;
    }

    static boolean passwordConsist(String a) {
        char[] letter = a.toCharArray();
        boolean isValid = true;
        for (int i = 0; i < letter.length; i++) {

            if ((letter[i] >= 48 && letter[i] <= 57) || (letter[i] >= 65 && letter[i] <= 90) || (letter[i] >= 97 && letter[i] <= 122)) {
                isValid = true;
            } else {
                isValid = false;
                System.out.println("Password must consist only of letters and digits"
                );
                break;
            }






        }
return isValid;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();

boolean isValid = true;


                if (!passwordLength(pass)) {
                    isValid = false;
                }
                if (!passwordConsist(pass)) {
                    isValid = false;
                }
                if (!atLeastTwoDigits(pass)) {
                    isValid = false;
                }

                if (isValid) {
                    System.out.println("Password is valid");
                }






    }
}
