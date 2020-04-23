package MidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        List<String> paints = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] commands = input.split(" ");

            if (commands[0].equals("Change") && paints.contains(commands[1])) {
                int index = paints.indexOf(commands[1]);
                paints.set(index,commands[2]);


            }
            if (commands[0].equals("Hide") && paints.contains(commands[1])) {
                paints.remove(commands[1]);
            }
            if (commands[0].equals("Switch") && paints.contains(commands[1]) && paints.contains(commands[2])) {
                int first = paints.indexOf(commands[1]);
                int second = paints.indexOf(commands[2]);
                Collections.swap(paints,first,second);
            }
            if (commands[0].equals("Insert") && paints.size() >= Integer.parseInt(commands[1])) {
                int nextIndex = Integer.parseInt(commands[1]);
                paints.add(nextIndex + 1,commands[2]);
            }
            if (commands[0].equals("Reverse")) {
                Collections.reverse(paints);
            }


        }
        System.out.println(paints.toString().replaceAll("[\\]\\[,]", ""));




    }
}
