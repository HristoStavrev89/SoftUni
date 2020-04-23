package StackIterator;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CustomStack stack = new CustomStack();

        String[] initialVAlues = scanner.nextLine().split(", +");

        stack.push(Integer.parseInt(initialVAlues[0].split(" +")[1]));

        for (int i = 1; i < initialVAlues.length; i++) {
            stack.push(Integer.parseInt(initialVAlues[i].trim()));
        }

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String command = input;

            if (command.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }

            } else {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }
        }

        for (int num : stack) {
            System.out.println(num);
        }
        for (int num : stack) {
            System.out.println(num);
        }
    }
}
