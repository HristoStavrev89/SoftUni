package ExercisesSecond;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String emailExtractor = "\\s[A-Za-z][\\w.-]*@[A-Za-z-]+(\\.[A-Za-z]+)+";

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(emailExtractor);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }

    }
}
