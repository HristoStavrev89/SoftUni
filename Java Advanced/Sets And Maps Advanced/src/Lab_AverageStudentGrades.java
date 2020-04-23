import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab_AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double grade = Double.parseDouble(data[1]);
            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }
        students.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.print(e.getKey() + " -> ");

                    double average = 0;
                    for (int i = 0; i < e.getValue().size(); i++) {
                        average += e.getValue().get(i);
                        System.out.printf("%.2f ",e.getValue().get(i));
                    }
                    System.out.printf("(avg: %.2f)", average / e.getValue().size());
                    System.out.println();
                });

    }
}
