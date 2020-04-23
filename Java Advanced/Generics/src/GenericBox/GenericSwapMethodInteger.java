package GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericSwapMethodInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());



        List<Box<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(scanner.nextLine());


            Box<Integer> box = new Box<>(num);

            boxes.add(box);
        }

        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        swapElements(boxes, firstIndex, secondIndex);

        for (Box<Integer> box : boxes) {
            System.out.println(box.toString());
        }

    }

    private static <T> void swapElements(List<Box<T>> boxes, int firstIndex, int secondIndex) {

        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }
}
