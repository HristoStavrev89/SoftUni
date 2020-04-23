package Figures;

import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int countOfStars = 0;
        int countOfDashes = 0;
        if (n % 2 == 0){
            countOfStars = 2;
        }else if(n % 2 != 0){

            countOfStars = 1;
        }

        countOfDashes = (n - countOfStars) / 2;
        for (int row = 0; row < (n + 1) / 2 ; row++) {


            String parts = repeatString("-", countOfDashes) + repeatString("*", countOfStars) + repeatString("-", countOfDashes);
            countOfStars += 2;
            countOfDashes-=1;
            System.out.println(parts);
        }

        for (int i = 0; i < n / 2   ; i++) {

            String bottom = "|" + repeatString("*", n -2) + "|";
            System.out.println(bottom);
        }
    }
    public static String repeatString(String text, int times) {
        StringBuilder result = new StringBuilder();

        while(times > 0) {
            result.append(text);

            times--;
        }

        return result.toString();
    }
}