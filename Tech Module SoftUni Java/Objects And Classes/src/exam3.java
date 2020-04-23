import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class exam3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> journal = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = "";

        while (!"Retire!".equals(input = scanner.nextLine())) {

            String[] commands = input.split(" - ");



            if (commands[0].equals("Start") && !journal.contains(commands[1])) {
                journal.add(commands[1]);
            }
            if (commands[0].equals("Complete") && journal.contains(commands[1])) {
                journal.remove(commands[1]);
            }
            if (commands[0].equals("Side Quest")) {
                String[] side = commands[1].split(":");
                if (journal.contains(side[0]) && !journal.contains(side[1])) {

                    int indexOfQuest = journal.indexOf(side[0]);
                    journal.add(indexOfQuest + 1,side[1]);
                }
            }
            if (commands[0].equals("Renew") && journal.contains(commands[1])) {
                int indexRemove = journal.indexOf(commands[1]);
                journal.add(commands[1]);
                journal.remove(indexRemove);
            }



        }

        System.out.println(journal.toString().replaceAll("[\\[\\]]",""));

    }
}
