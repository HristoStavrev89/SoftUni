import java.text.DecimalFormat;
import java.util.*;

public class Lab_A_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counts = new TreeMap<>();


        for (int i = 0; i < nums.length; i++) {
            double number = nums[i];
            if (!counts.containsKey(nums[i])) {
                counts.put(number, 0);
            }
            counts.put(number, counts.get(number) + 1);
        }



        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.println(String.format("%s -> %d",df.format(entry.getKey()),entry.getValue()));
        }



    }
}
