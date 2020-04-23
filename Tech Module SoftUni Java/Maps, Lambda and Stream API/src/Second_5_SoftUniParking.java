import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Second_5_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> parking = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String command = data[0];

            if (command.equals("register")) {
                String name = data[1];
                String number = data[2];

                if (!parking.containsKey(name)) {
                    parking.put(name, number);
                    System.out.println(String.format("%s registered %s successfully",
                            name, number));
                } else {
                    System.out.println(String.format("ERROR: already registered with plate number %s"
                            , number));
                }
            }
            if (command.equals("unregister")) {
                String name = data[1];
                if (!parking.containsKey(name)) {
                    System.out.println(String.format("ERROR: user %s not found", name));
                } else {
                    System.out.println(String.format("%s unregistered successfully", name));
                    parking.remove(name);
                }
            }
        }

        parking.entrySet().stream()
                .forEach(person -> {
                    System.out.println(String.format("%s => %s",
                            person.getKey(),person.getValue()));
                });


    }
}
