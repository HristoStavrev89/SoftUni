import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exrecise_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int delitel = Integer.parseInt(scanner.nextLine());


        Predicate<Integer> possible = num -> num % delitel != 0;

        Collections.reverse(numbers);

        numbers.stream()
        .filter(e -> possible.test(e))
                .forEach(number -> System.out.print(number + " "));






    }
}
