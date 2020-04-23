package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);

            people.add(person);


        }


        people
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted((p1,p2) ->p1.getName().compareTo(p2.getName()))
                .forEach(e -> {
                    System.out.println(e.toString());
                });



    }
}
