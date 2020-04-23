import java.util.Scanner;

public class Cat_Life {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String poroda = scanner.nextLine();
        String pol = scanner.nextLine();
        int result = 0;

        if (poroda.equals("British Shorthair") && pol.equals("m")) {
             result = (13 * 12) / 6;
        } else if (poroda.equals("British Shorthair") && pol.equals("f")) {
            result = (14 * 12) / 6;
        } else if (poroda.equals("Siamese") && pol.equals("m")) {
            result = (15 * 12) / 6;
        } else if (poroda.equals("Siamese") && pol.equals("f")) {
            result = (16 * 12) / 6;
        } else if (poroda.equals("Persian") && pol.equals("m")) {
            result = (14 * 12) / 6;
        } else if (poroda.equals("Persian") && pol.equals("f")) {
            result = (15 * 12) / 6;
        } else if (poroda.equals("Ragdoll") && pol.equals("m")) {
            result = (16 * 12) / 6;
        } else if (poroda.equals("Ragdoll") && pol.equals("f")) {
            result = (17 * 12) / 6;
        } else if (poroda.equals("American Shorthair") && pol.equals("m")) {
            result = (12 * 12) / 6;
        } else if (poroda.equals("American Shorthair") && pol.equals("f")) {
            result = (13 * 12) / 6;
        } else if (poroda.equals("Siberian") && pol.equals("m")) {
            result = (11 * 12) / 6;
        } else if (poroda.equals("Siberian") && pol.equals("f")) {
            result = (12 * 12) / 6;
        } else {
            System.out.println(poroda +" is invalid cat!");
            return;
        }

        System.out.println(result + " cat months");



    }
}
