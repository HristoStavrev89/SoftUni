import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab_8_MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String dateFormat = "\\b(?<day>[\\d]{2})([\\/\\-.])(?<month>[A-Z]{1}[a-z]{2})\\2(?<year>[0-9]{4}+)\\b";

        Pattern pattern = Pattern.compile(dateFormat);

        String input = scanner.nextLine();

        Matcher dates = pattern.matcher(input);

        while (dates.find()) {
            String day = dates.group("day");
            String month = dates.group("month");
            String year = dates.group("year");

            System.out.println(String.format("Day: %s, Month: %s, Year: %s",
                    day,
                    month,
                    year));
        }



    }
}
