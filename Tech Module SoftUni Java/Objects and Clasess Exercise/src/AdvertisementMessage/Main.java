package AdvertisementMessage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Messege messege = new Messege();

        for (int i = 0; i < n; i++) {
            String randomMessege = messege.randomMessage();
            System.out.println(randomMessege);
        }



    }
}
