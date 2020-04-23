package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String[] data = scanner.nextLine().split(", ");

        Articles articles = new Articles(data[0],data[1],data[2]);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(": ");
            String command = input[0];


            if (command.equals("Edit")) {
                articles.edit(input[1]);
            } else if (command.equals("ChangeAuthor")) {
                articles.changeAuthor(input[1]);
            } else if (command.equals("Rename")) {
                articles.rename(input[1]);
            }

        }
        System.out.println(articles);


    }
}
