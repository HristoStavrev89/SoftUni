import java.util.Scanner;

public class Online_Education {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);

        String firstRegistration = scanner.nextLine();
        int firstRegistrationNum = Integer.parseInt(scanner.nextLine());
        String secondRegistration = scanner.nextLine();
        int secondRegistrationNum = Integer.parseInt(scanner.nextLine());
        String thirdRegistration = scanner.nextLine();
        int thirdRegistrtionNum = Integer.parseInt(scanner.nextLine());
        int ostatuk = 0;

        int onsiteStudents = 0;
        int onlineStudents = 0;

        int total = firstRegistrationNum + secondRegistrationNum + thirdRegistrtionNum;

        if (firstRegistration.equals("onsite")) {
            onsiteStudents += firstRegistrationNum;
        } else if (firstRegistration.equals("online")) {
            onlineStudents += firstRegistrationNum;
        }
        if (secondRegistration.equals("onsite")) {
            onsiteStudents += secondRegistrationNum;
        } else if (secondRegistration.equals("online")) {
            onlineStudents += secondRegistrationNum;
        }
        if (thirdRegistration.equals("onsite")) {
            onsiteStudents += thirdRegistrtionNum;
        } else if (thirdRegistration.equals("online")) {
            onlineStudents += thirdRegistrtionNum;
        }

        if (onsiteStudents > 600) {
            ostatuk = onsiteStudents - 600;
            onsiteStudents = 600;
            onlineStudents += ostatuk;
        }


        System.out.println("Online students: " + onlineStudents);
        System.out.println("Onsite students: " + onsiteStudents);
        System.out.println("Total students: " + total);



    }
}
