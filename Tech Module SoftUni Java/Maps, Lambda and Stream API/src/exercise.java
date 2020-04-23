import java.util.*;
import java.util.stream.Collectors;

public class exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // String text = String.join("",scanner.nextLine().split("\\s+"));
        String[] text = scanner.nextLine().split("\\s");

        Map<Character, Integer> data = new LinkedHashMap<>();

        for (int i = 0; i < text.length; i++) {
            String word = text[i];

            for (int j = 0; j < word.length(); j++) {
                char current = word.charAt(j);

                if (!data.containsKey(current)) {
                    data.put(current, 1);
                } else {
                    data.put(current, data.get(current) + 1);
                }

            }
        }

        // Normal print method, without stream api
//        for (Map.Entry<Character, Integer> kvp : data.entrySet()) {
//            System.out.println(kvp.getKey() + " -> " + kvp.getValue());
//        }

        // With stream api
        data.entrySet().stream().forEach(e -> {
            System.out.println(String.format("%c -> %d",e.getKey(),e.getValue()));
        });



    }
}
