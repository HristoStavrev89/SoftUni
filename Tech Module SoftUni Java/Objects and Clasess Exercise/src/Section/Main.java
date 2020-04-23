package Section;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(scanner.nextLine());

        String title = input[0];
        String content = input[1];
        String author = input[2];

        Section section = new Section(title,content,author);

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(": ");

            if (data[0].equals("Edit")) {
                section.edit(data[1]);
            }
            if (data[0].equals("ChangeAuthor")) {
                section.changeAuthor(data[1]);
            }
            if (data[0].equals("Rename")) {
                section.rename(data[1]);
            }


        }
        System.out.println(section);




    }
}
