import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab_7_PhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        String sofiaPhone = "\\+359[-]2[-][\\d]{3}[-][0-9]{4}\\b|\\+359[ ]2[ ][\\d]{3}[ ][0-9]{4}\\b";

        Pattern pattern = Pattern.compile(sofiaPhone);
        Matcher matcher = pattern.matcher(input);
        List<String> phones = new ArrayList<>();

        while (matcher.find()) {
            phones.add(matcher.group());
        }

        System.out.println(String.join(", ", phones));

    }
}
