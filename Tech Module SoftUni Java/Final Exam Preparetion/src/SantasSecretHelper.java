import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int key = Integer.parseInt(scanner.nextLine());

        String input = "";


        while (!"end".equals(input = scanner.nextLine())) {
            String data = input;

            String name = "";

            for (int i = 0; i < data.length(); i++) {
                char current = (char) (data.charAt(i) - key);
                name += current;


            }

            String checker = "@(?<name>[A-Za-z]+).+(?<status>![G]!)";
            Pattern pattern = Pattern.compile(checker);
            Matcher matcher = pattern.matcher(name);

            while (matcher.find()) {
                System.out.println(matcher.group("name"));



            }






        }
    }
}
