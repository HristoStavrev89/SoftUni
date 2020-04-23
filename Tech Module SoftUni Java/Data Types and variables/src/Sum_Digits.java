import java.util.Scanner;

public class Sum_Digits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


      //  String numsAsText = scanner.nextLine();
      //  int sum = 0;
//
      //  for (int i = 0; i < numsAsText.length(); i++) {
      //      sum += Integer.parseInt(String.valueOf(numsAsText.charAt(i)));
      //  }
//
      //  System.out.println(sum);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (num > 0) {
           sum += num % 10;
           num /= 10;

        }
        System.out.println(sum);

    }
}
