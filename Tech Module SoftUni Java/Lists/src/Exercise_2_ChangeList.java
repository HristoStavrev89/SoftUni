import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_2_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine()
        .split(" ")).collect(Collectors.toList());


        while (true) {
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");

            if (input.equals("end")) {
                break;
            }

            switch (tokens[0]) {
                case "Delete":
                  numbers  =  numbers
                            .stream()
                            .filter(e -> !e.equals(tokens[1]))
                            .collect(Collectors.toList());
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    String element = tokens[1];
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index,element);
                    }


                    break;

            }



        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]",""));







    }
}
