import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_5_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> names = new LinkedHashMap<>();




        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");


            if (commands[0].equals("register")) {
                String name = commands[1];
                String number = commands[2];

                if (!names.containsKey(name)) {
                    names.put(name, number);
                    System.out.println(String.format("%s registered %s successfully",
                           name,number));
                } else {
                    if (names.containsKey(name)) {
                        Map.Entry<String,String> entry = names.entrySet().iterator().next();
                         // ERROR?! ^^
                        System.out.println(String.format("ERROR: already registered with plate number %s"
                                ,entry.getValue()));
                    }
                }
            }
            if (commands[0].equals("unregister")) {
                String name = commands[1];
                if (names.containsKey(name)) {
                    System.out.println(String.format("%s unregistered successfully",
                            name));
                    names.remove(name);
                } else {
                    System.out.println(String.format("ERROR: user %s not found",
                            commands[1]));
                }
            }

        }

        names.entrySet().stream()
                .forEach((e) -> {
                    System.out.println(String.format("%s => %s",e.getKey(),e.getValue()));
                });

    }
}
