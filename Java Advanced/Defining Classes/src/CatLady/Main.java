package CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        HashMap<String, Cat> cats = new HashMap<>();


        while (!"End".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String breed = data[0];
            String name = data[1];
            double specialData = Double.parseDouble(data[2]);

            Cat cat = null;

            switch (breed) {
                case "Siamese":
                    cat = new SiameseCat(name, specialData);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetCat(name, specialData);
                    break;

                case "Cymric":
                    cat = new CymricCat(name, specialData);
                    break;
            }

            cats.putIfAbsent(name, cat);
        }

        String catName = scanner.nextLine();


        Cat cat = cats.get(catName);
        System.out.println(cat.toString());


    }
}
