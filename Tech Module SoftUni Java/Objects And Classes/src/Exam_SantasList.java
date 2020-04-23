import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam_SantasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kids = Arrays.stream(scanner.nextLine()
                .split("&"))
                .collect(Collectors.toList());

        String input = "";


        while (!"Finished!".equals(input = scanner.nextLine())) {

            String[] commands = input.split(" ");

            if (commands[0].equals("Bad") && !kids.contains(commands[1])) {
                kids.add(0,commands[1]);
            }
            if (commands[0].equals("Good") && kids.contains(commands[1])) {
                kids.remove(commands[1]);
            }
            if (commands[0].equals("Rename") && kids.contains(commands[1])) {
                String oldName = commands[1];
                int index = kids.indexOf(commands[1]);
                kids.set(index, commands[2]);
                kids.remove(oldName);
            }
            if (commands[0].equals("Rearrange") && kids.contains(commands[1])) {
                int index = kids.indexOf(commands[1]);
                kids.add(commands[1]);
                kids.remove(index);
            }


        }

        System.out.println(kids.toString().replaceAll("[\\[\\]]", ""));
    }
}
