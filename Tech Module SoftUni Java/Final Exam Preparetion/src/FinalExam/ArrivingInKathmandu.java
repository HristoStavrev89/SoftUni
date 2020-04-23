package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String regex = "(?<name>[A-Za-z]+)|[!@#$?]+=(?<length>[0-9]+)<<(?<geo>.+)";
        Pattern pattern = Pattern.compile(regex);

        while (!"Last note".equals(input = scanner.nextLine())) {

            String name = "";
            String length = "";
            String geo = "";

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {

               name += matcher.group("name");

            }


            System.out.println();



        }

    }
}
