import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHystory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String input = "";

        while (!"Home".equals(input = scanner.nextLine())) {

            if (!input.equals("back")) {
                history.push(input);
                System.out.println(input);
            } else {
                if (history.size() > 1) {
                    history.pop();
                    System.out.println(history.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }




        }


    }
}
