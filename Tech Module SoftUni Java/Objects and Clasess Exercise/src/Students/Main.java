package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            String first = data[0];
            String last = data[1];
            double grade = Double.parseDouble(data[2]);

            Student student = new Student(first,last,grade);

            students.add(student);



        }

        students.stream().sorted((s1,s2) -> Double.compare(s2.getGrade(),s1.getGrade()))
                .forEach(e -> System.out.println(e.toString()));




    }
}
