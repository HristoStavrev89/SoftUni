import java.io.*;

public class B_Write_FIle {
    public static void main(String[] args) {


        String pathIn = "C:\\Users\\Stavrev\\Desktop\\input.txt";
        String pathOut = "C:\\Users\\Stavrev\\Desktop\\output.txt";


        try (FileReader fis = new FileReader(pathIn)) {
            FileWriter fos = new FileWriter(pathOut);
            int oneByte = fis.read();
            while (oneByte >= 0) {
                System.out.println(oneByte);
                if (oneByte == 32 || oneByte == 10) {
                    fos.write(oneByte);
                } else {

                    String byteAsText = Integer.toString(oneByte);

                    System.out.println();

                    for (int i = 0; i < byteAsText.length(); i++) {
                        fos.write(byteAsText.charAt(i));
                    }

                }
                oneByte = fis.read();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
