package Dec_16_2018;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      // Guns n'roses:NOVEMBER RAIN
        String input = "";

        String text = "\\A[A-Z][ ' a-z]+:[A-Z ]+\\z";
        Pattern pattern = Pattern.compile(text);
        while (!"end".equals(input = scanner.nextLine())) {
            String data = input;

            Matcher matcher = pattern.matcher(data);

            if (matcher.find()) {

                StringBuilder decript = decriptator(data);
                System.out.println("Successful encryption: " + decript);

            } else {
                System.out.println("Invalid input!");
            }
        }
    }
    private static StringBuilder decriptator(String text) {
        String[] findKey = text.split(":");
        int key = findKey[0].length();
        String result = "";

        StringBuilder stringBuilder = new StringBuilder(result);

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            if (current == 32 ) {
                stringBuilder.append(" ");
                continue;
            } else if (current == 39) {
                stringBuilder.append("'");
                continue;
            } else if (current == 58) {
                stringBuilder.append("@");
                continue;
            }
            int character = current + key;
            if (character < 65) {
                continue;
            }
            if (character > 90 && character < 100) {

                character = 65 + (character - 90) - 1;
                char cast = (char) character;

                stringBuilder.append(cast);

            } else if (character > 122){
                character = 97 + (character - 122) - 1;
                char cast = (char) character;

                stringBuilder.append(cast);
            }
            else {
                char toChar = (char) character;
                stringBuilder.append(toChar);
            }
        }
        return stringBuilder;

    }
}
