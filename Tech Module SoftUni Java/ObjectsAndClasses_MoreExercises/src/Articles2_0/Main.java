package Articles2_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Articles2_0> listArticles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];

            Articles2_0 articles2_0 = new Articles2_0(title,content,author);

            listArticles.add(articles2_0);
        }

        String command = scanner.nextLine();

        if (command.equals("title")) {
            listArticles
                    .stream().sorted((object1,object2) -> object1.getTitle().compareTo(object2.getTitle()))
                    .forEach(e -> {
                        System.out.println(e);
                    });

        }
        else if (command.equals("content")) {

            listArticles
                    .stream()
                    .sorted((object1,object2) -> object1.getContent().compareTo(object2.getContent()))
                    .forEach(e -> {
                        System.out.println(e);
                    });

        }
        else if (command.equals("author")) {
            listArticles
                    .stream()
                    .sorted((object1,object2) -> object1.getAuthor().compareTo(object2.getAuthor()))
                    .forEach(e -> {
                        System.out.println(e);
                    });
        }



    }
}
