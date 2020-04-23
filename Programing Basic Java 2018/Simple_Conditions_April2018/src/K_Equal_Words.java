import java.util.Scanner;

public class K_Equal_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().toLowerCase();
        String word1 = scanner.nextLine().toLowerCase();


        if (word.equals(word1)) {
            System.out.println("yes");
        } else System.out.println("no");
    }
}
