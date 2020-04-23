import java.util.Scanner;

public class EqualWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().toLowerCase();
        String secondword = scanner.nextLine().toLowerCase();


        if (word.equals(secondword)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
