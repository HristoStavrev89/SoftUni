import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class LaB_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


      //  Predicate<Integer> youngerThan = x ->

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> persons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(",\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            persons.putIfAbsent(name, age);


        }

        String comparison = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        if (printType.equals("name age")) {
            if (comparison.equals("older")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() >= age)
                        .forEach(man -> {
                            System.out.println(String.format("%s - %d",man.getKey(),man.getValue()));
                        });


            } else if (comparison.equals("younger")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() <= age)
                        .forEach(man -> {
                            System.out.println(String.format("%s - %d",man.getKey(),man.getValue()));
                        });
            }
        } else if (printType.equals("age name")) {
            if (comparison.equals("older")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() >= age)
                        .forEach(man -> {
                            System.out.println(String.format("%d - %s",man.getValue(),man.getKey()));
                        });
            } else if (comparison.equals("younger")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() <= age)
                        .forEach(man -> {
                            System.out.println(String.format("%d - %s",man.getValue(),man.getKey()));
                        });
            }
        }
        if (printType.equals("name")) {
            if (comparison.equals("younger")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() <= age)
                        .forEach(man -> {
                            System.out.println(String.format("%s",man.getKey()));
                        });
            } else if (comparison.equals("older")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() >= age)
                        .forEach(man -> {
                            System.out.println(String.format("%s",man.getKey()));
                        });
            }
        }
        if (printType.equals("age")) {
            if (comparison.equals("younger")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() <= age)
                        .forEach(man -> {
                            System.out.println(String.format("%d",man.getValue()));
                        });
            } else if (comparison.equals("older")) {
                persons
                        .entrySet()
                        .stream()
                        .filter((person) -> person.getValue() >= age)
                        .forEach(man -> {
                            System.out.println(String.format("%d",man.getValue()));
                        });
            }
        }





    }
}
