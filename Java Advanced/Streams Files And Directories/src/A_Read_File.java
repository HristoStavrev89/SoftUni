import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class A_Read_File {
    public static void main(String[] args) {



        String path = "D:\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.println(String.format("%s ",
                        Integer.toBinaryString(oneByte)));
                oneByte = fileStream.read();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
