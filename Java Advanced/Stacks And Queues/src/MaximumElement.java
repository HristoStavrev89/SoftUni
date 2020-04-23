import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.contains("1 ")) {
                String[] command = input.split("\\s+");
                stack.push(Integer.parseInt(command[1]));
            } else if (input.equals("2")) {
                stack.pop();
            } else if (input.equals("3")) {
                System.out.println(Collections.max(stack));
               // System.out.println(stack.stream().max(Integer::compareTo).get());
            }
        }
    }
}
