import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      //  ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());


        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String command = input[0];

            if (command.equals("1")) {
                text.append(input[2]);

            }
            if (command.equals("2")) {
               int count = Integer.parseInt(input[1]);
               text.substring(text.length() - count);
             }




        }



    }
}
