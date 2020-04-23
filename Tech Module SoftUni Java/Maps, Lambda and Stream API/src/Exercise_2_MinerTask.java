import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_2_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String input = "";

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!"stop".equals(input = scanner.nextLine())) {

            String material = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(material)) {
                resources.put(material, quantity);
            } else {
                resources.put(material, resources.get(material) + quantity);
            }


        }

//        for (Map.Entry<String, Integer> matrial : resources.entrySet()) {
////            System.out.println(String.format("%s -> %d",matrial.getKey(),matrial.getValue()));
////        }

        resources.entrySet().forEach(e -> {
            System.out.println(String.format("%s -> %d",e.getKey(),e.getValue()));
        });

    }
}
