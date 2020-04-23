import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_3_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstLine = Arrays.stream(scanner.nextLine()
        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondLine = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> outputLine = new ArrayList<>();

        int minLength = Math.min(firstLine.size(),secondLine.size());

        for (int i = 0; i < minLength; i++) {
            outputLine.add(firstLine.get(i));
            outputLine.add(secondLine.get(i));
        }
        if (firstLine.size() > secondLine.size()) {
            outputLine.addAll(firstLine.subList(minLength - 1,firstLine.size()));
        } else {
            outputLine.addAll(secondLine.subList(minLength - 1,secondLine.size()));
        }

        System.out.println(outputLine.toString().replaceAll("\\[|,|\\]",""));
    }
}
