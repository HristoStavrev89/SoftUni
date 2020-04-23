package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");


            switch (data.length) {
                case 1:
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);

                    System.out.println(String.format("Account ID%d created",bankAccount.getId()));

                    break;
                case 2:
                    double rateSet = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(rateSet);

                    break;
                case 3:
                    int id = Integer.parseInt(data[1]);
                    if (!bankAccountMap.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount bk1 = bankAccountMap.get(id);
                        if ("Deposit".equalsIgnoreCase(data[0])) {
                            double amount = Double.parseDouble(data[2]);
                            bk1.deposit(amount);

                            System.out.println(String.format("Deposited %.0f to ID%d",amount,id));

                        } else {

                            int yesrs = Integer.parseInt(data[2]);
                            System.out.println(String.format("%.2f",bk1.getInterest(yesrs)));
                        }
                    }




                    break;
            }





        }



    }
}
