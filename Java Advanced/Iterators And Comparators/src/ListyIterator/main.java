package ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListyIterator iterator = new ListyIterator(list);

        String input = scanner.nextLine();


        while (!input.equals("END")) {
            String output = "";

            if (input.equals("Move")) {
                output = iterator.move() ? "true" : "false";


            } else if (input.equals("Print")) {
                    try {
                        output = iterator.print();
                    } catch (IllegalAccessException exception) {
                        output = exception.getMessage();
                    }

            } else if (input.equals("HasNext")) {
                output = iterator.hasNext() ? "true" : "false";


            } else if (input.equals("PrintAll")) {
                iterator.printAll();
                System.out.println();
            }

            if (!output.equals("")) {
                System.out.println(output);
            }

            input = scanner.nextLine();

        }

    }
}
