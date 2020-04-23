import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_5_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());




        while (true) {
            String input = scanner.nextLine();


            if (input.equals("end")) {
                break;
            }

            String[] tokens = input.split(" ");



            switch (tokens[0]) {
                case "Contains":
                    int containsNum = Integer.parseInt(tokens[1]);
                    if (numbers.contains(containsNum)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }

                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0) {
                                System.out.print(numbers.get(i) + " ");

                            }
                        }
                        System.out.println();

                    } else if (tokens[1].equals("odd")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0) {
                                System.out.print(numbers.get(i) + " ");

                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sumOfTheNUmbers = 0;
                    for (int i = 0; i < numbers.size(); i++) {
                        sumOfTheNUmbers += numbers.get(i);
                    }
                    System.out.println(sumOfTheNUmbers);
                    break;
                case "Filter":
                    if (tokens[1].equals("<")) {
                        int filterNumb = Integer.parseInt(tokens[2]);
                        for (int i = 0; i <numbers.size() ; i++) {
                            if (filterNumb > numbers.get(i)) {
                                System.out.print(numbers.get(i) + " ");
                            }


                        }
                        System.out.println();
                    }
                    else if (tokens[1].equals(">")) {
                        int numFilter = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numFilter < numbers.get(i)) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (tokens[1].equals(">=")) {
                        int numFilter = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numFilter <= numbers.get(i)) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (tokens[1].equals("<=")) {
                        int numFilter = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numFilter >= numbers.get(i)) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

            }



        }




    }
}
