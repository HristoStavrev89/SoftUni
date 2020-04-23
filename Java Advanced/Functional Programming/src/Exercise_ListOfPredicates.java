import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class Exercise_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] people = scanner.nextLine().split("\\s+");

        String input = "";

        HashMap<String, Predicate<String>> predicates = new HashMap<>();

        while (!"Print".equals(input = scanner.nextLine())) {
            String[] data = input.split(";");

            String command = data[0];
            String filterType = data[1];
            String filterParameter = data[2];
            String filterName = filterType + filterParameter;


            if (command.contains("Add")) {

                Predicate<String> predicate;

                if (filterType.contains("Starts")) {
                    predicate = name -> name.startsWith(filterParameter);
                } else if (filterName.contains("Ends")) {
                    predicate = name -> name.endsWith(filterParameter);
                } else if (filterName.contains("Length")) {
                    predicate = name -> name.length() == Integer.parseInt(filterParameter);
                } else {
                    predicate = name -> name.contains(filterParameter);
                }

                predicates.putIfAbsent(filterName, predicate);

            } else {

                predicates.remove(filterName);

            }


        }

        Arrays.stream(people)
                .forEach(name -> {
                    boolean[] hasToBeFiltered = new boolean[1];
                    predicates.forEach((k, v) -> {

                        if (v.test(name)) {
                           hasToBeFiltered[0] = true;
                       }
                    });

                    if (!hasToBeFiltered[0]) {
                        System.out.print(name + " ");
                    }


                });


    }
}
