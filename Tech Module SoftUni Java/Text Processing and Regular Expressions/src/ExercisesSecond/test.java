package ExercisesSecond;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String participants = "(?<name>[A-Za-z]+)|(?<distance>\\d+)";

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(participants);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            String name = matcher.group("name");
            String distance = matcher.group("distance");
            System.out.println();


        }



    }
}
