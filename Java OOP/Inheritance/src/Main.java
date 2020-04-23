import animals.Animal;
import animals.Cat;
import animals.Tomcat;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";



        while (!"Beast".equals(input = scanner.nextLine())) {
        String type = scanner.nextLine();
        String[] data = scanner.nextLine().split("\\s+");
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        String gender = data[2];


        }


    }
}
