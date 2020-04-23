import java.util.*;

public class Lab_C_Odd_Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().toLowerCase().split("\\s+");

        Map<String, Integer> words = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String current = input[i];

            if (!words.containsKey(current)) {
                    words.put(current, 1);
                } else {
                    words.put(current, words.get(current) + 1);
                }
        }

        List<String> lqlq = new ArrayList<>();

        words.entrySet().stream()
                .filter(e -> e.getValue() % 2 != 0)
                .forEach(e -> {
                    String k = e.getKey();
                    lqlq.add(k);
                });
        System.out.println(lqlq.toString().replaceAll("[\\]\\[]",""));

    }
}
