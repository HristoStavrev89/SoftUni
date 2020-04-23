import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class L_Copy_Picture {
    public static void main(String[] args) throws IOException {

        String picDir = "C:\\Users\\Stavrev\\Desktop\\pale blue dot\\paleBlueDot.jpg";


        FileInputStream inputStream = new FileInputStream(picDir);


        byte[] image = inputStream.readAllBytes();


        FileOutputStream outputStream = new FileOutputStream("The-Pale-Blue-Dot.jpg");


        outputStream.write(image);

        outputStream.close();

    }
}
