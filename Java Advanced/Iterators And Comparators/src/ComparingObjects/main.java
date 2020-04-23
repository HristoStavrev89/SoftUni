package ComparingObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        List<Person> people = new ArrayList<>();

        // Person by age
      //  Collections.sort(people, new PersonByAge());

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];

            Person person = new Person(name, age, town);

            people.add(person);

            input = scanner.nextLine();
        }


        int index = Integer.parseInt(scanner.nextLine()) - 1;

        Person find = people.get(index);

        int equalPeople = 0;

        for (Person person : people) {
            if (person.compareTo(find) == 0) {
                equalPeople++;
            }
        }

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d"
                    , equalPeople
                    , people.size() - equalPeople
                    , people.size()));
        }
    }
}
