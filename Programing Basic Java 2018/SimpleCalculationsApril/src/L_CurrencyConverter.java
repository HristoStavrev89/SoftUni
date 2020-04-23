import java.util.Scanner;

public class L_CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        String value1 = scanner.nextLine();
        String value2 = scanner.nextLine();

        if (value1.equals("USD")){
            num = num * 1.79549;
        }else if (value1.equals("EUR")){
            num = num * 1.95583;
        }else if (value1.equals("GBP")){
            num = num * 2.53405;
        } if (value2.equals("USD")){
            num = num / 1.79549;
        }else if (value2.equals("EUR")){
            num = num / 1.95583;
            String to = "EUR";
        }else if (value2.equals("GBP")){
            num = num / 2.53405;
            String to = "GBP";
        }else if (value2.equals("BGN"))
            num = num;
        String to = "BGN";
        System.out.printf("%.2f %s",num ,to);
    }
}
