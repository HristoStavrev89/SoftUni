package April_06_2019_demo.MidExam16Apr2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        List<String> gifts = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String input = "";

        while (!"No Money".equals(input = scanner.nextLine())) {

            String[] data = input.split(" ");
            String command = data[0];

            if (command.equals("OutOfStock") && gifts.contains(data[1])) {
                String none = "None";
                for (int i = 0; i < gifts.size(); i++) {
                    if (gifts.get(i).equals(data[1])) {
                        gifts.set(i, none);
                    }

                }
            }

            if (command.equals("Required")) {
                String gift = data[1];
                int index = Integer.parseInt(data[2]);

                if (index < gifts.size()) {
                    gifts.set(index, gift);

                }

            }
            if (command.equals("JustInCase")) {
                int lastIndex = gifts.size() - 1;
                gifts.remove(lastIndex);
                gifts.add(data[1]);

            }


        }
        List<String> newGifts = new ArrayList<>();


        for (int i = 0; i < gifts.size(); i++) {
            if (!gifts.get(i).equals("None")) {
                newGifts.add(gifts.get(i));
            }


        }

        System.out.print(newGifts.toString().replaceAll("[\\]\\[,]", ""));



    }
}
