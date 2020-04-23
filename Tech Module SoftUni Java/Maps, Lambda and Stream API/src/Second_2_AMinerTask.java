import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Second_2_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = "";

        while (!"stop".equals(input = scanner.nextLine())) {
            String material = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(material)) {
                resources.put(material, quantity);
            } else {
                resources.put(material, resources.get(material) + quantity);
            }
        }

        resources.entrySet().stream().forEach(r -> {
            System.out.println(String.format("%s -> %d",r.getKey(),r.getValue()));
        });


    }
}
