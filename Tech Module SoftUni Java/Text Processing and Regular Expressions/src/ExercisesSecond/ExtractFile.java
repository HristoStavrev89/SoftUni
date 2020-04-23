package ExercisesSecond;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fileDirectory = scanner.nextLine().split("\\\\");

        String last = fileDirectory[fileDirectory.length - 1];
        int point = last.lastIndexOf(".");

        String name = last.substring(0, point);
        String extension = last.substring(point + 1);

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);
    }
}
