import java.io.*;

public class G_Sum_Bytes {
    public static void main(String[] args) throws IOException {



        String useDir = System.getProperty("user.dir");
        String pathIn = useDir + "/res/input.txt";
       // String pathOut = "/res/output.txt";


        BufferedReader reader = new BufferedReader(new FileReader(pathIn));

      //  FileOutputStream fos = new FileOutputStream(pathOut);

        String line = reader.readLine();

        int sum = 0;

        while (line != null) {

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            line = reader.readLine();
        }

        System.out.println(sum);



    }
}
