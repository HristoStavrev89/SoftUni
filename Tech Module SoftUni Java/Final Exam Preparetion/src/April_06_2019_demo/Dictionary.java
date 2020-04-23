package April_06_2019_demo;


import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(" \\| ");

        Map<String, ArrayList<String>> dictionary = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String[] text = input[i].split(": ");
            String word = text[0];
            String definition = text[1];

            if (!dictionary.containsKey(word)) {
                dictionary.put(word, new ArrayList<>());
                dictionary.get(word).add(definition);
            } else {
                dictionary.get(word).add(definition);
            }

        }

        List<String> words = Arrays.stream(scanner.nextLine().split(" \\| "))
                .collect(Collectors.toList());


        for (int i = 0; i < words.size(); i++) {
            String current = words.get(i);

            if (dictionary.containsKey(current)) {
                System.out.println(current);
                dictionary.get(current).stream()
                        .sorted((x,y) -> Integer.compare(y.length(), x.length()))
                        .forEach(x -> System.out.println(" -" + x));
            }
        }

        String command = scanner.nextLine();

        if (command.equals("List")) {
            dictionary.entrySet().stream()
                    .forEach(word -> System.out.printf("%s ",word.getKey()));
        } else {
            return;
        }


    }


}

