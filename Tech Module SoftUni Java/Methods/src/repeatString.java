import java.util.Scanner;

public class repeatString {
     static String repeatString (String str, int count) {
        String result = "";
         for (int i = 0; i < count; i++) {
            System.out.print(str);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        repeatString(scanner.nextLine(),Integer.parseInt(scanner.nextLine()));


    }
}
