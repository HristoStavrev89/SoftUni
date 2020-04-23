package OrderbyAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<SchoolData> student = new ArrayList<>();

        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split(" ");

            String name = data[0];
            int id = Integer.parseInt(data[1]);
            int ages = Integer.parseInt(data[2]);

            SchoolData schoolData = new SchoolData(name,id,ages);

            student.add(schoolData);


        }
        student
                .stream()
                .sorted((a1,a2) -> Integer.compare(a1.getAge(),a2.getAge()))
                .forEach(s -> {
                    System.out.println(s);
                });



    }
}
