import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercises_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";
        Map<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equals(input = scanner.nextLine())) {
            String name = input;
            String email = scanner.next();
            scanner.nextLine();

            if (email.contains("bg")) {
                emails.put(name, email);
            }
        }

        emails.forEach((K, V) -> {
            System.out.println(K + " -> " + V);
        });


    }
}
