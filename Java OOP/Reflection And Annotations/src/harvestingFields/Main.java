package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Field[] fields = RichSoilLand.class.getDeclaredFields();


        String input = "";


        while (!"HARVEST".equals(input = scanner.nextLine())) {

            if (input.equals("all")) {
                Arrays.stream(fields).forEach(field ->
                        System.out.println(String.format("%s %s %s"
                                , Modifier.toString(field.getModifiers())
                                , field.getType().getSimpleName()
                                , field.getName())));
            } else {

                String finalInput = input;

                Arrays
                        .stream(fields)
                        .filter(f -> Modifier.toString(f.getModifiers()).equals(finalInput))
                        .forEach(field ->
                        System.out.println(String.format("%s %s %s"
                                , Modifier.toString(field.getModifiers())
                                , field.getType().getSimpleName()
                                , field.getName())));
            }


        }


    }
}
