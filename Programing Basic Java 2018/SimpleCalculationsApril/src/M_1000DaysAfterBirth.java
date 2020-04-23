import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class M_1000DaysAfterBirth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter format =DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(scanner.nextLine(),format);
        LocalDate result = localDate.plusDays(999);
        System.out.println(format.format(result));
    }
}
