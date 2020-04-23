import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MidExamFebruaryGroup2Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> words = Arrays.stream(scanner.nextLine()
        .split(" ")).collect(Collectors.toList());

        String input = "";

        while (!"Stop".equals(input = scanner.nextLine())) {
            String[] commands = input.split(" ");

            if (commands[0].equals("Delete")) {
                int index = Integer.parseInt(commands[1]);
                words.remove(index + 1);
            }
            if (commands[0].equals("Swap") && words.contains(commands[1]) && words.contains(commands[2])) {
                Collections.swap(words,words.indexOf(commands[1]),words.indexOf(commands[2]));
            }
            if (commands[0].equals("Put")) {
                int index = Integer.parseInt(commands[2]);
                words.add(index - 1,commands[1]);
            }
            if (commands[0].equals("Sort")) {
                Collections.sort(words,Collections.reverseOrder());
            }
            if (commands[0].equals("Replace") && words.contains(commands[2])) {
                words.set(words.indexOf(commands[2]),commands[1]);
            }

        }

        for (String word : words) {
            System.out.print(word + " ");
        }


    }
}
