import java.util.Scanner;

public class greaterOfTwoValues {
    static int getMax(int a, int b) {
        int result;
        if (a > b) {
            result = a;
        } else {
            result = b;
        }
        return result;
    }
    static char getMaxChar (String a, String b) {
        char result;
        if (a.charAt(0) > b.charAt(0)) {
            result = a.charAt(0);
        } else {
            result = b.charAt(0);
        }
        return result;
    }
    static String getMax (String a, String b) {
        String result;
        if (a.length() > b.length()) {
            result = a;
        } else {
            result = b;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        if (dataType.equals("int")) {
            int first = Integer.parseInt(scanner.nextLine());
            int second = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(first,second));
        } else if (dataType.equals("char")) {
            String first =  scanner.nextLine();
            String second =  scanner.nextLine();
            System.out.println(getMaxChar(first,second));
        } else if (dataType.equals("String")) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(getMax(a,b));
        }

    }
}
