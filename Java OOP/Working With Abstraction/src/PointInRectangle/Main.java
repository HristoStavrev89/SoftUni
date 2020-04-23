package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] coordinate = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Point bottomLeft = new Point(coordinate[0], coordinate[1]);
        Point topRight = new Point(coordinate[2], coordinate[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            Point newppPoint = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangle.contains(newppPoint));


        }


    }
}
