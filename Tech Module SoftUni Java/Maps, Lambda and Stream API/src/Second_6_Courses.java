import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Second_6_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, ArrayList<String>> courses = new LinkedHashMap<>();

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split(" : ");

            String program = data[0];
            String name = data[1];

            if (!courses.containsKey(program)) {
                courses.put(program, new ArrayList());
                courses.get(program).add(name);
            } else {
                courses.get(program).add(name);
            }
        }


        courses
                .entrySet()
                .stream()
                .sorted((s1,s2) -> Integer.compare(s2.getValue().size(),s1.getValue().size()))
                .forEach(program -> {
                    System.out.println(String.format("%s: %d",program.getKey(),program.getValue().size()));


                    program.getValue()
                            .stream()
                            .sorted((s1,s2) ->
                            s1.compareTo(s2))
                            .forEach(p -> {
                                System.out.println(String.format("-- %s",p));
                            });

                });


    }
}
