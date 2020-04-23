import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Lab_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).addAll(grades);
        }

        DecimalFormat format = new DecimalFormat("#.##################");
        students.forEach((name, grade) -> {
            double avg = grade.parallelStream().mapToDouble(e -> e).sum() / grade.size();
            System.out.println(String.format("%s is graduated with %s",
                    name,
            format.format(avg))
            );
        });


    }
}
