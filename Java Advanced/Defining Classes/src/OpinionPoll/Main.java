package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] nameAge = scanner.nextLine().split("\\s+");
            String name = nameAge[0];
            int years = Integer.parseInt(nameAge[1]);
            if (years > 30) {
                Person person = new Person(name, years);
//                person.setName(nameAge[0]);
//                person.setAges(Integer.parseInt(nameAge[1]));
                people.add(person);
//                System.out.println(String.format("%s - %d",
//                        person.getName(),
//                        person.getAges()));
            }

        }
        people.stream().sorted((man1, man2) -> man1.getName().compareTo(man2.getName()))
                .forEach(man -> System.out.println(man.getName() + " - " + man.getAges()));


    }
}
