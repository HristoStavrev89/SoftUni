import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Second_7_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> classbook = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!classbook.containsKey(name)) {
                classbook.put(name, new ArrayList<>());
                classbook.get(name).add(grade);
            } else {
                classbook.get(name).add(grade);
            }
        }

        Map<String, Double> averageGrade = new LinkedHashMap<>();


        for (Map.Entry<String, ArrayList<Double>> kvp : classbook.entrySet()) {
            // Take average value from -classbook- and save the new average value in -averageGrade-
            double average = kvp.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
            if (average >= 4.50) {
                averageGrade.put(kvp.getKey(), average);
            }

        }

       averageGrade
               .entrySet()
               .stream()
               .sorted((g1,g2) -> Double.compare(g2.getValue(),g1.getValue()))
               .forEach(e -> {
                   System.out.println(String.format("%s -> %.2f",e.getKey(), e.getValue()));
               });


    }
}
