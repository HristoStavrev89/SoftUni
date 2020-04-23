import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_6_ReplaceRepeatingStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        Write a program that reads a string from the console and replaces any sequence
//        of the same letters with a single corresponding letter.

       // input:  aaaaabbbbbcdddeeeedssaa
        // ouput:   abcdedsa


        String input = scanner.nextLine();
        System.out.println(input.replaceAll("(.)\\1{1,}", "$1"));



    }
}
