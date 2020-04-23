import java.util.*;
import java.util.regex.Pattern;

public class Exercises_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        //   Key(Key Value))
        Map<String, Map<String, Integer>> users = new TreeMap<>();


        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");


            String iP = data[0].substring(3);
            String messege = data[1].substring(9);
            String name = data[2].substring(5);

            if (!users.containsKey(name)) {
                users.put(name, new LinkedHashMap<>());

            }

            if (users.containsKey(name) && !users.get(name).containsKey(iP)) {
                users.get(name).put(iP, 1);
            } else {
                users.get(name).put(iP, users.get(name).get(iP) + 1);
            }


        }


        users.forEach((k1, k2) -> {
            System.out.println(k1 + ": ");
            k2.forEach((adres, count) -> {
                 System.out.print(String.format("%s => %d, ", adres, count));
            });
        });


    }
}