package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        Lights[] lights = new Lights[input.length];

        for (int i = 0; i < input.length; i++) {
            lights[i] = Lights.valueOf(input[i]);
        }


        Lights[] lightsValues = {Lights.RED, Lights.GREEN, Lights.YELLOW};

        StringBuilder builder = new StringBuilder();

        while (n-- > 0) {


            for (int i = 0; i < lights.length; i++) {

                if (lights[i].ordinal() == 2) {
                    lights[i] = Lights.RED;
                } else {
                    lights[i] = lightsValues[lights[i].ordinal() + 1];
                }
              //  System.out.print(lightsValues[lights[i].ordinal()] + " ");
                builder.append(lightsValues[lights[i].ordinal()]).append(" ");

            }
            builder.append(System.lineSeparator());

        }

        System.out.println(builder.toString());


    }
}
