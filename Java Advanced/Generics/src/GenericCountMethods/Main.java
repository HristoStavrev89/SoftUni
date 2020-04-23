package GenericCountMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int lines = Integer.parseInt(scanner.nextLine());

        List<Boxx<String>> boxxes = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
           // double num = Double.parseDouble(scanner.nextLine());

            String str = scanner.nextLine();

            Boxx<String> box = new Boxx<>(str);

            boxxes.add(box);
        }

       // double element = Double.parseDouble(scanner.nextLine());

        String element = scanner.nextLine();

        int result = countGreatestElements(boxxes, element);


        System.out.println(result);
    }

    private static<T extends Comparable<T>> int countGreatestElements(List<Boxx<T>> boxxes, T element) {

        int count = 0;

        for (Boxx<T> boxx : boxxes) {
            if (boxx.getElement().compareTo(element) > 0) {
                count++;
            }
        }
        return count;


    }
}
