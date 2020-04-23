import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercises_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = "";

        int counter = 1;

        while (!"stop".equals(input = scanner.nextLine())) {
           // counter++;

                String mineral = input;
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (!resources.containsKey(mineral)) {
                    resources.put(mineral, quantity);
                } else {
                    resources.put(mineral, resources.get(mineral) + quantity);
                }
        }

        resources.forEach((K, V) -> {
            System.out.println(K + " -> " + V);
        });


    }
}
