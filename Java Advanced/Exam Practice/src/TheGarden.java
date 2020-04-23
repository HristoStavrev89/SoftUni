import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int n = Integer.parseInt(scanner.nextLine());


        String[][] garden = new String[n][];


        for (int i = 0; i < n; i++) {
            garden[i] = scanner.nextLine().split("\\s+");
        }


        String input = "";



        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmed = 0;



        while (!"End of Harvest".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String command = data[0];


            if (command.equals("Harvest")) {
                int row = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);

                if (row < n && row >= 0) {
                    int length = garden[row].length - 1;
                    if (col <= length && col >= 0) {
                        if (!garden[row][col].equals(" ")) {
                            if (garden[row][col].equals("L")) {
                                lettuce++;
                                garden[row][col] = " ";
                            } else if (garden[row][col].equals("P")) {
                                potatoes++;
                                garden[row][col] = " ";
                            } else if (garden[row][col].equals("C")) {
                                carrots++;
                                garden[row][col] = " ";
                            }
                        }
                    }
                }
            }

            if (command.equals("Mole")) {
                int red = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);
                String direction = data[3];

                if (red <= n) {

                    if (direction.equals("up")) {
                        for (int i = red; i >= 0; i-=2) {
                            if (!garden[i][col].equals(" ")) {
                                garden[i][col] = " ";
                                harmed++;
                            }

                        }
                    } else if (direction.equals("down")) {
                        for (int i = red; i <= n; i+=2) {
                            if (!garden[i][col].equals(" ")) {
                                garden[i][col] = " ";
                                harmed++;
                            }

                        }
                    } else if (direction.equals("right")) {
                        //todo maybe
                        for (int i = col; i <= garden[red].length; i+=2) {
                            if (!garden[red][i].equals(" ")) {
                                garden[red][i] = " ";
                                harmed++;
                            }

                        }
                    } else if (direction.equals("left")) {
                        for (int i = col; i >= 0; i-=2) {
                            if (!garden[red][i].equals(" ")) {
                                harmed++;
                                garden[red][i] = " ";
                            }

                        }
                    }
                }
            }
        }
        for (int i = 0; i < garden.length; i++) {
            System.out.println();
            for (int j = 0; j < garden[i].length; j++) {
                System.out.print(garden[i][j] + " ");
            }
        }

        System.out.println();
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmed);


    }
}
