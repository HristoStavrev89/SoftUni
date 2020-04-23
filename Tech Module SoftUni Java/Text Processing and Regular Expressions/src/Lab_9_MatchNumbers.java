import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab_9_MatchNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String matchNumbers = "(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))";

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile(matchNumbers);
        Matcher matcher = pattern.matcher(text);

        List<String> numbers = new ArrayList<>();

        while (matcher.find()) {
            numbers.add(matcher.group());


        }
        System.out.println(String.join(" ", numbers));



    }
}
