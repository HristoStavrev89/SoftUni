import java.util.*;

public class Exercise_7_Student_Academy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            } else {
                students.get(name).add(grade);
            }
        }



    }
}
