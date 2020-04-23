package ExercisesSecond;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] names = scanner.nextLine().split(", ") ;

        Map<String, Integer> result = new LinkedHashMap<>();

        for (String name : names) {
            if (!result.containsKey(name)) {
                result.put(name, 0);
            }
        }

        String input = "";
        String lettersExtract = "(?<name>[A-Za-z]+)";
        String digitsExtract = "(?<number>\\d+)";

        while (!"end of race".equals(input = scanner.nextLine())) {
            String data = input;
            String name = "";
            String numbers = "";


            // name
            Pattern pattern = Pattern.compile(lettersExtract);
            Matcher matcher = pattern.matcher(data);

            //distance
            Pattern digitsPatern = Pattern.compile(digitsExtract);
            Matcher matherDigits = digitsPatern.matcher(data);


            while (matcher.find()) {
                String letter = matcher.group("name");
                name += letter;
            }
            while (matherDigits.find()) {
                String digit = matherDigits.group("number");
                numbers += digit;
            }

            int distance = Integer.parseInt(numbers);


            if (result.containsKey(name)) {
                result.put(name, result.get(name) + distance);
            }

        }



        List<String> namesSort = new LinkedList<>();

        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()).limit(3).forEach(p -> namesSort.add(p.getKey()));

        System.out.printf("1st place: %s\n" +
                "2nd place: %s\n" +
                "3rd place: %s",namesSort.get(0), namesSort.get(1),namesSort.get(2));



    }
}
