import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MidExamFebruaryGroup2Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> fire = Arrays.stream(scanner.nextLine().split("#"))
                .collect(Collectors.toList());

        List<Integer> cells = new ArrayList<>();
        int water = Integer.parseInt(scanner.nextLine());

        double effort = 0;
        int index = 0;
        while (water > 0) {

            String[] values = fire.get(index).split(" = ");
            String type = values[0];
            int power = Integer.parseInt(values[1]);

            if (power > 0 && power < 51 && type.equals("Low") && water >= power) {
                water -= power;
                effort = effort + (power * 0.25);
                cells.add(power);
            } else
            if (power > 50 && power < 81 && type.equals("Medium") && water >= power) {
                water -= power;
                effort = effort + (power * 0.25);
                cells.add(power);
            } else
            if (power > 80 && power < 126 && type.equals("High") && water >= power) {
                water -= power;
                effort = effort + (power * 0.25);
                cells.add(power);
            }


            if (index == fire.size() - 1) {
                break;
            } else {
                index++;
            }


        }

        System.out.printf("Cells:%n");
        for (int cell : cells) {
            System.out.println("- " + cell);
        }

        System.out.printf("Effort: %.2f%n", effort);

        int sum = 0;

        for (int cell : cells) {
            sum += cell;
        }
        System.out.println("Total Fire: " + sum);


    }
}
