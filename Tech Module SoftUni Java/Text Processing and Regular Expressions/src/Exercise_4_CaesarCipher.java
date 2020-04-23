import java.util.Scanner;

public class Exercise_4_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(cryptCharacter(input));

    }
    private static String cryptCharacter (String text) {
        String crypt = "";


        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int number = current + 3;
            char next = (char) number;
            crypt += next;
        }
        return crypt;
    }
}
