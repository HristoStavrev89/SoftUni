import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Exrcises_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Consumer<ArrayList<Integer>> printer = arr ->  arr.forEach(num -> System.out.print(num + " "));


        Function<ArrayList<Integer>, ArrayList<Integer>>  add = list -> list.stream()
                .map(e -> ++e).collect(Collectors.toCollection(ArrayList::new));

        UnaryOperator<ArrayList<Integer>> multiply =
                list -> list.stream()
                .map(e -> e *= 2).collect(Collectors.toCollection(ArrayList::new));

        UnaryOperator<ArrayList<Integer>> subtact =
                list -> list.stream()
                        .map(e -> e -= 1).collect(Collectors.toCollection(ArrayList::new));


        String input = "";

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayList::new));


        while (!"end".equals(input = scanner.nextLine())) {
            if (input.equals("add")) {
                numbers = add.apply(numbers);
            }
            if (input.equals("print")) {
                printer.accept(numbers);
                System.out.println();
            }
            if (input.equals("multiply")) {

                numbers = multiply.apply(numbers);

            }
            if (input.equals("subtract")) {

                numbers = subtact.apply(numbers);
            }

        }




    }
}
