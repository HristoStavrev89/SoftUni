package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");


        String title = data[0];
        String content = data[1];
        String author = data[2];


        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(": ");

            String command = input[0];


            switch (command) {
                case "Edit":
                    article.edit(input[1]);

                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.reneme(input[1]);
                    break;
            }

        }
        System.out.println(article);

    }
}
