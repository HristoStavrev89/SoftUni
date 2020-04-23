import java.io.File;

public class Main {
    public static void main(String[] args) {


        File f = new File("D:\\");

        File[] allFiles = f.listFiles();

        if (allFiles == null) return;

        for (File file : allFiles) {
            if (file.isFile()) {
                System.out.println(String.format("%s: %d", file.getName(), file.length()));
            }
        }
    }
}
