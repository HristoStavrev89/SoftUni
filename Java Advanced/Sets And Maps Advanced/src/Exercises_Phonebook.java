import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercises_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(input = scanner.nextLine())) {
            String[] data = input.split("-");

            String name = data[0];
            String number = data[1];

            phonebook.put(name, number);

        }


        while (!"stop".equals(input = scanner.nextLine())) {
            String name = input;

            if (phonebook.containsKey(name)) {
                System.out.println(String.format("%s -> %s",input, phonebook.get(name)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", name));
            }


        }






    }
}
