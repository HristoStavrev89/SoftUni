import java.util.Arrays;
import java.util.Scanner;

public class condenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();

        int[] condensed = new int[numbers.length - 1];



        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < condensed.length - i; j++) {
                condensed[j] = numbers[j] + numbers[j + 1];
            }
            numbers = condensed;





        }


        System.out.println(condensed[0]);


//        Write a program to read an array of integers and condense them by summing adjacent couples
//        of elements until a single integer is obtained. For example, if we have 3 elements {2, 10, 3},
//        we sum the first two and the second two elements and obtain
//        {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.





    }
}
