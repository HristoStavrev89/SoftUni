import java.lang.reflect.Array;
import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] nsx = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int pushStack = nsx[0];
        int popStack = nsx[1];
        int checkElement = nsx[2];

        // Filing the Stack with Integers
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(pushStack)
                .forEach(stack::push);


        for (int i = 0; i < popStack; i++) {
            stack.pop();
        }

        if (stack.contains(checkElement)) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println(0);
            } else {

                System.out.println(Collections.min(stack));

//                int min = Integer.MAX_VALUE;
//
//                while (!stack.isEmpty()) {
//                    int number = stack.pop();
//                    if (number < min) {
//                        min = number;
//                    }
//                }
//                System.out.println(min);

            }
        }



    }
}
