package April_06_2019_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();

        String[] letters = scanner.nextLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String allIn = "\\A[d-z#|{}]+\\Z";
        Pattern pattern = Pattern.compile(allIn);
        Matcher matcher = pattern.matcher(text);
        boolean yes = false;

        if (matcher.find()) {
            yes = true;
        }
        String encode = "";

        if (yes) {
            for (int i = 0; i < text.length(); i++) {
                char current = text.charAt(i);
                char decode = (char) (current - 3);
                encode += decode;

            }
        } else {
            System.out.println("This is not the book you are looking for.");
            return;

        }



        String[] encodeSplit = encode.split(" ");

        String finale = "";
        for (int i = 0; i < encodeSplit.length; i++) {
           finale += encodeSplit[i].replaceAll(letters[0], letters[1]);
           finale += " ";

        }
        System.out.println(finale.trim());









    }
}
