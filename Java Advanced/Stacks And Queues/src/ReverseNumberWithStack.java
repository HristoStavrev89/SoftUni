import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumberWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> stack.push(e));

        // Alternatve
//        String[] nums = scanner.nextLine().split("\\s+");
//        for (String num : nums) {
//            stack.push(Integer.parseInt(num));
//        }

        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }


    }
}
