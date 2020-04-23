import java.io.*;

public class D_ThirdLine {
    //Write every third line.
    public static void main(String[] args) {


        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";


        int position = 1;
        try (BufferedReader bfr = new BufferedReader(new FileReader(pathIn));
              BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))){

            String line = bfr.readLine();

            while (line != null) {

                if (position % 3 == 0) {
                    bfw.append(line).append(System.lineSeparator());
                }
                position++;
                line = bfr.readLine();
            }




        }  catch (IOException e) {
            e.printStackTrace();
        }



    }
}
