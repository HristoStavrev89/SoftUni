package ExercisesSecond;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String nameValidator = "(?<name>(^| )[\\d\\w-_]{3,16}\\b)";
        String names = scanner.nextLine();

        Pattern pattern = Pattern.compile(nameValidator);

        Matcher matcher = pattern.matcher(names);

        while (matcher.find()) {
            String name = matcher.group("name");
            System.out.println(String.format("%s",name.trim()));
        }



    }
}
