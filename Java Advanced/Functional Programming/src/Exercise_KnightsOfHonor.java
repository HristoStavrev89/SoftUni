import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Exercise_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Consumer<String> honor = person -> System.out.println("Sir " + person);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(honor);


    }
}
