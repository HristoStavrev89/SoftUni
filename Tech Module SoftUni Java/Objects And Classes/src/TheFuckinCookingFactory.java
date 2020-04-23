import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFuckinCookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        int highestTotalQuality = 0;
        double greaterAverageQuality = 0;
        int size = 0;

        List<Integer> bestAvgQuality = new ArrayList<>();

        while (!"Bake It!".equals(input = scanner.nextLine())) {
            List<Integer> bread = Arrays.stream(input.split("#"))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int sum = 0;
            for (int i = 0; i < bread.size(); i++) {
                sum += bread.get(i);
            }
            double average = (double) sum / bread.size();
            int batchSize = bread.size();
            if (size < batchSize) {
                size = batchSize;
            }
            if (sum > highestTotalQuality) {
                bestAvgQuality.clear();
                for (int brot : bread) {
                    bestAvgQuality.add(brot);
                }
                greaterAverageQuality = average;
                highestTotalQuality = sum;
            } else if (sum == highestTotalQuality && average > greaterAverageQuality) {
                bestAvgQuality.clear();
                for (int brot : bread) {
                    bestAvgQuality.add(brot);
                }
                greaterAverageQuality = average;
                highestTotalQuality = sum;
            } else if (sum == highestTotalQuality && average == greaterAverageQuality && size > bread.size()) {
                bestAvgQuality.clear();
                for (int brot : bread) {
                    bestAvgQuality.add(brot);
                }
                greaterAverageQuality = average;
                highestTotalQuality = sum;
            }

        }

        System.out.println("Best Batch quality: " + highestTotalQuality);
        System.out.println(bestAvgQuality.toString().replaceAll("[\\]\\[,]", ""));


    }
}
