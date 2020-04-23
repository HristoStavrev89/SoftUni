import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";

        CustomList<String> customList = new CustomList<>();

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String command = data[0];

            switch (command) {
                case "Add":
                    customList.add(data[1]);
                    break;

                case "Remove":
                    int index = Integer.parseInt(data[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    System.out.println(customList.contains(data[1]));
                    break;
                case "Swap":
                    int first = Integer.parseInt(data[1]);
                    int second = Integer.parseInt(data[2]);
                    customList.swap(first, second);
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(data[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                   customList.printList(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;


            }


        }


    }


}
