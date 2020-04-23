import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String work = scanner.nextLine();


        int sum = 0;
        for (int i = 0; i < work.length(); i++) {
            if (work.charAt(i) > 47 && work.charAt(i) < 58) {
                sum  +=  Character.getNumericValue(work.charAt(i));
            }

        }
    }
}
