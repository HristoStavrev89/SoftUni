package Perspective;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<perspective> perspectives = new ArrayList<>();



        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            perspective perspective = new perspective(name,age);

            perspectives.add(perspective);

        }

        perspectives
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(perspective::getName))
                .forEach(e -> {
                    System.out.println(e.toString());
                });


    }
}
