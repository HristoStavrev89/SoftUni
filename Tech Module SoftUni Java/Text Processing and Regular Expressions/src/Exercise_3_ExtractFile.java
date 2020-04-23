import java.util.Scanner;

public class Exercise_3_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] directory = scanner.nextLine().split("\\\\");

        String last = directory[directory.length - 1];
        int point = last.indexOf('.');
        String name = last.substring(0, point);
        String file = last.substring(last.lastIndexOf('.') + 1);

        System.out.println("File name: " + name);
        System.out.println("File extension: " + file);








    }
}
