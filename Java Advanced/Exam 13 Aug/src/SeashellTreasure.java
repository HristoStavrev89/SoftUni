import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeashellTreasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        int n = Integer.parseInt(scanner.nextLine());

        String[][] beach = new String[n][];


        for (int i = 0; i < n; i++) {
            beach[i] = scanner.nextLine().split("\\s+");
        }


        List<String> collect = new ArrayList<>();

        int stolenSeaShells = 0;


        String inpit = "";

        while (!"Sunset".equals(inpit = scanner.nextLine())){
            String[] data = inpit.split("\\s+");

            String command = data[0];


            if (command.equals("Collect")) {
                int row = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);

                if (row < n && row >= 0) {
                    int length = beach[row].length - 1;
                    if (col <= length && col >= 0) {

                            if (beach[row][col].equals("M")) {

                                collect.add(beach[row][col]);
                                beach[row][col] = "-";
                            } else if (beach[row][col].equals("C")) {

                                collect.add(beach[row][col]);
                                beach[row][col] = "-";
                            } else if (beach[row][col].equals("N")) {

                                collect.add(beach[row][col]);
                                beach[row][col] = "-";
                            }

                    }
                }
            }
            if (command.equals("Steal")){
                int row = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);
                String direction = data[3];


                if (direction.equals("right")) {

                    //todo check this
                    if (row <= n && col < beach[col].length){

                        for (int i = col; i < beach[col].length; i++) {
                            if (beach[row][i] != null) {
                                if (beach[row][i].equals("M") || beach[row][i].equals("N") || beach[row][i].equals("C")){
                                    stolenSeaShells++;
                                }
                                beach[row][i] = "-";
                            }
                        }
                    }
                } else if (direction.equals("left")){
                    if (row <= n && col >= 0){
                        for (int i = col; i >= 0; i--) {
                            if (beach[row][i] != null) {
                                if (beach[row][i].equals("M") || beach[row][i].equals("N") || beach[row][i].equals("C")){
                                    stolenSeaShells++;
                                }
                                beach[row][i] = "-";
                            }
                        }
                    }
                } else if (direction.equals("up")){
                    if (row <= n && col < beach[col].length){
                        for (int i = row; i >= 0; i--) {
                            if (beach[i][col] != null){
                                if (beach[i][col].equals("M") || beach[i][col].equals("N") || beach[i][col].equals("C")){
                                    stolenSeaShells++;
                                }
                                beach[i][col] = "-";
                            }
                        }
                    }
                } else if (direction.equals("down")) {
                    if (row < n && col < beach[col].length){
                        for (int i = row; i <= 3; i++) {

                            if (beach[i][col] != null) {
                                if (beach[i][col].equals("M") || beach[i][col].equals("C") || beach[i][col].equals("N")){
                                    stolenSeaShells++;
                                }
                                beach[i][col] = "-";

                            }

                        }
                    }
                }

            }


        }

        for (int i = 0; i < beach.length; i++) {
            System.out.println();
            for (int j = 0; j < beach[i].length; j++) {
                System.out.print(beach[i][j] + " ");
            }
        }




        System.out.println();
        String listString = collect.toString().replaceAll("[\\]\\[]", "");


        if (collect.size() == 0) {
            System.out.println("Collected seashells: " + collect.size());
        } else {
            System.out.println("Collected seashells: " + collect.size() + " -> " + listString);
        }


        System.out.println("Stolen seashells: " + stolenSeaShells);

    }
}
