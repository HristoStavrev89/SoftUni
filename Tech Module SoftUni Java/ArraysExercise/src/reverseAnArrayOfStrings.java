import java.util.Scanner;

public class reverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        for (int i = 0; i < array.length / 2; i++) {
          String oldElements = array[i];
          array[i] = array[array.length - 1 - i];
          array[array.length - 1 - i] = oldElements;
        }

        for (String elements : array) {
            System.out.print(elements + " ");
        }

//        Write a program to read an array of strings, reverse it and print its elements.
//                The input consists of a sequence of space separated strings.
//                Print the output on a single line (space separated).

    }
}

