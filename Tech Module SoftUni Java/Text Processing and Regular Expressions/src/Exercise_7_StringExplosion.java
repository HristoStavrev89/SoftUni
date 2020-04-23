import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_7_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();

        String result = "";
        int power = 0;

        for (int i = 0; i < text.length(); i++) {
            result += text.charAt(i);

            if (text.charAt(i) == '>') {
               power += Integer.parseInt(String.valueOf(text.charAt(i + 1)));

            }

            while (power > 0) {
                power --;

                i ++;

                if (i + 1 == text.length() || text.charAt(i + 1) == '>'){
                    break;
                }
            }

        }
        System.out.println(result);




    }
}
