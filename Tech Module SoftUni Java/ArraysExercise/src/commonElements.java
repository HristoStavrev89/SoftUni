import java.util.Scanner;

public class commonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");


        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < first.length; j++) {
                if (second[i].equals(first[j])) {
                    System.out.printf(second[i] + " ");
                    break;
                }
            }
        }
//        Common Elements
//        Write a program, which prints common elements in two arrays.
//        You have to compare the elements of the second array to the elements of the first.



    }
}
