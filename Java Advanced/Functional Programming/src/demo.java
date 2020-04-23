import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());



//        Function<List<Integer>, Integer> smallestNum = list -> {
//            List<Integer> sorted = list.stream()
//                    .sorted()
//                    .collect(Collectors.toList());
//            return sorted.get(0);
//        };

        numbers.stream().sorted().forEach(num -> System.out.print(num + " "));

    }
}
