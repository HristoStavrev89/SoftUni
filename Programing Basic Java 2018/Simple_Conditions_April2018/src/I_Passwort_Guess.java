import java.util.Scanner;

public class I_Passwort_Guess {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        String pass = scaner.nextLine();

        if (pass.equals("s3cr3t!P@ssw0rd")) {
            System.out.println("Welcome");
        }
        else System.out.println("Wrong password!");
    }
}
