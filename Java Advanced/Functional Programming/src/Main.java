import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String status;
//        int lvl = Integer.parseInt(reader.readLine());
//
//
//        status = lvl == 1 ? "epic fail" : "noob";
//
//        System.out.println("lvl: " + status);


        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());


        String c = a + b == 10 ? "10 e" : "ne e 10";


        System.out.println(c);
    }
}
