import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> nums = new ArrayDeque<>();
        String input = scanner.nextLine();
        String [] lqlq = input.split("\\s+");

        for (int i = lqlq.length - 1; i >= 0; i--) {
            nums.push(lqlq[i]);
        }

        while (nums.size() > 1) {

            Integer firstNum = Integer.parseInt(nums.pop());
            String op = nums.pop();
            Integer secondNum = Integer.parseInt(nums.pop());

            if ("+".equalsIgnoreCase(op)) {
                nums.push(firstNum + secondNum + "");
            } else {
                nums.push(firstNum - secondNum + "");
            }
        }
        System.out.println(nums.peek());

    }
}
