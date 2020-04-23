import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] nsx = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int numElements = nsx[0];
        int elementsPoll = nsx[1];
        int elementCheck = nsx[2];

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(numElements)
                .forEach(queue::offer);

        for (int i = 0; i < elementsPoll; i++) {
            queue.poll();
        }

        if (queue.contains(elementCheck)) {
            System.out.println("true");
        } else if (queue.size() == 0) {
            System.out.println(queue.size());
        }
        else {
            System.out.println(Collections.min(queue));
        }



    }
}
