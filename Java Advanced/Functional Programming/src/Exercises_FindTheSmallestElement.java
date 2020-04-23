import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercises_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//                    Find the smallest element
//        Write a program which is using  a custom function (written by you) to find the smallest integer in a sequence of integers. The input could have more than one space.
//        Your task is to collect the integers from the console, find the smallest one and print its index (if more than one such elements exist, print the index of the rightmost one).


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());



        Function<List<Integer>, Integer> smallestNum = list -> {
            List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
            return sorted.get(0);
        };

        int result = numbers.lastIndexOf(smallestNum.apply(numbers));
        System.out.println(result);


    }
}
