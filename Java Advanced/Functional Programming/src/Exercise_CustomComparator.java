import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//
//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt).collect(Collectors.toList());

//        int[] numbersArray = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt).toArray();

        String[] numsAsStrings = scanner.nextLine().split("\\s+");

        Integer[] numbers = new Integer[numsAsStrings.length];

        for (int i = 0; i < numsAsStrings.length; i++) {
            numbers[i] = Integer.parseInt(numsAsStrings[i]);
        }

        Comparator<Integer> comparator = (f, s) -> {
            int result;

            if (f % 2 == 0 && s % 2 != 0) {
                result = -1;
            } else if (s % 2 == 0 && f % 2 != 0) {
                result = 1;
            } else {
                result = f - s;
            }
            return result;
        };

        Arrays.sort(numbers, comparator);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
