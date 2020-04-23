import javax.swing.event.ListSelectionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_7_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> characters = Arrays.stream(scanner.nextLine()
        .split("\\|")).collect(Collectors.toList());


        Collections.reverse(characters);

        String prnt = characters.toString().replaceAll("[\\[\\],]","").trim();

        prnt = prnt.replaceAll("\\s+", " ");

        System.out.println(prnt);










    }

}
