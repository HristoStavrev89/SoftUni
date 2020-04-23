import java.util.*;

public class Lab_B_Word_Synonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonim = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonim);
        }

        for (Map.Entry<String, List<String>> kvp : words.entrySet()) {
            String key = kvp.getKey();
            String value = String.join(", ", kvp.getValue());

            System.out.println(String.format("%s - %s",key, value));
        }


    }
}
