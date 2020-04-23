import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_4_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (true) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            if (input.equals("End")) {
                break;
            }

            if (tokens[0].equals("Add")) {
                int addNum = Integer.parseInt(tokens[1]);
                numbers.add(addNum);
                continue;
                } else if (tokens[0].equals("Insert")) {
                int index = Integer.parseInt(tokens[2]);
                int num = Integer.parseInt(tokens[1]);
                if (index > numbers.size() || index < 0) {
                    System.out.println("Invalid index");
                    continue;
                }
                numbers.add(index,num);
            }

                 if (tokens[0].equals("Remove")) {
                int removeIndex = Integer.parseInt(tokens[1]);
                if (removeIndex > numbers.size() || removeIndex < 0) {
                    System.out.println("Invalid index");
                    continue;
                }
                numbers.remove(removeIndex);

             }
             if (tokens[1].equals("left")) {
                int count = Integer.parseInt(tokens[2]);
                for (int i = 0; i < count; i++) {
                    int firstNum = numbers.get(0);
                    numbers.add(firstNum);
                    numbers.remove(0);


                }
            } else if (tokens[1].equals("right")) {
                int count = Integer.parseInt(tokens[2]);
                for (int i = 0; i < count; i++) {
                    int lastNum = numbers.get(numbers.size() - 1);
                    numbers.add(0,lastNum);
                    numbers.remove(numbers.size() - 1);

                }
            }
        }


for (int nums : numbers) {
    System.out.print(nums + " ");
}



    }
}
