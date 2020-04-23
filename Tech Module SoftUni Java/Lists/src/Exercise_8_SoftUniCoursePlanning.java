import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_8_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        String input = "";

        while (!"course start".equals(input = scanner.nextLine())){

            String[] commands = input.split(":");

            if (commands[0].equals("Add")) {

                if (!(lessons.contains(commands[1]))) {
                    lessons.add(commands[1]);
                    continue;

                }
            } else if (commands[0].equals("Insert")) {
                if (!(lessons.contains(commands[1]))) {
                    int index = Integer.parseInt(commands[2]);
                    lessons.add(index,commands[1]);
                    continue;

                }

            } else if (commands[0].equals("Remove")) {
                if (lessons.contains(commands[1])) {
                    lessons.remove(commands[1]);
                    continue;

                }
            } else if (commands[0].equals("Swap")) {
                swap(lessons,commands[1],commands[2]);
                continue;


            } else if (commands[0].equals("Exercise")) {

                if (lessons.contains(commands[1]) && !(lessons.contains(commands[1] + "-Exercise"))) {
                    int index = lessons.indexOf(commands[1]);
                    lessons.add(index + 1,commands[1] + "-Exercise");
                    continue;


                } else if (!lessons.contains(commands[1])) {
                    lessons.add(commands[1]);
                    lessons.add(commands[1] + "-Exercise");
                    continue;

                }
            }

        }

        for (int i = 0; i < lessons.size(); i++) {
            System.out.println(i + 1 + "." + lessons.get(i));
        }

    }
    private static List<String> swap(List<String> lessons, String lessonTitle, String secondLessonTitle) {
        boolean exist = false;
        boolean secondExist = false;

        String exerciseTitle = lessonTitle + "-Exercise";
        boolean exerciseExist = false;
        String secondExerciseTitle = secondLessonTitle + "-Exercise";
        boolean secondExerciseExist = false;

        if (lessons.contains(lessonTitle)) {
            exist = true;
            if (lessons.contains(exerciseTitle)) exerciseExist = true;
        }
        if (lessons.contains(secondLessonTitle)) {
            secondExist = true;
            if (lessons.contains(secondExerciseTitle)) secondExerciseExist = true;
        }

        if (exist && secondExist) {
            int firstTitleIndex = lessons.indexOf(lessonTitle);
            int secondTitleIndex = lessons.indexOf(secondLessonTitle);
            lessons.set(firstTitleIndex, secondLessonTitle);
            lessons.set(secondTitleIndex, lessonTitle);
            if (exerciseExist) {
                lessons.remove(exerciseTitle);
                lessons.add(lessons.indexOf(lessonTitle)+1, exerciseTitle);
            }
            if (secondExerciseExist) {
                lessons.remove(secondExerciseTitle);
                lessons.add(lessons.indexOf(secondLessonTitle)+1, secondExerciseTitle);
            }
        }

        return lessons;
    }
}
