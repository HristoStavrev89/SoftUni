package Dec_16_2018;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();
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

            if (character > 90 && character < 97) {

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
        System.out.println(stringBuilder);

    }
}
