import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("");


        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("{")) {
                stack.push(1);
            } else if (input[i].equals("[")) {
                stack.push(2);
            } else if (input[i].equals("(")) {
                stack.push(3);
            }
            if (input[i].equals("}")) {
                queue.offer(1);
            } else if (input[i].equals("]")) {
                queue.offer(2);
            } else if (input[i].equals(")")) {
                queue.offer(3);
            }
        }

        boolean isIt = true;

        if (queue.size() == stack.size()) {
            for (int i = 0; i < stack.size(); i++) {
                int first = stack.pop();
                int second = queue.poll();

                if (first != second) {
                    isIt = false;
                } else {
                    isIt = true;
                }
            }

        } else {
            isIt = false;
        }


        if (isIt) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }





    }
}
