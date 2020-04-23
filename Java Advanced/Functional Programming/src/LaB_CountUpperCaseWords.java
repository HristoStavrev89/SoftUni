import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LaB_CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

          List<String> upperCaseWords = Arrays.stream(input).filter(isUpperCase)
                .collect(Collectors.toList());


          // First Variant
        System.out.println(upperCaseWords.size());
        upperCaseWords.stream().forEach(word -> System.out.println(word));

        //Second Variant
//        for (String word : input) {
//            if (isUpperCase.test(word)) {
//                System.out.println(word);
//            }
//        }
        // Third Variant
//        Arrays
//                .stream(input)
//                .filter((word) -> isUpperCase.test(word))
//                .forEach((wordWithUpperCase) -> {
//                    System.out.println(wordWithUpperCase);
//                });




    }
}
