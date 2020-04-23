import java.io.*;

public class H_Count_Character_Type {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";


        int consonants = 0;
        int vowels = 0;
        int punctuation = 0;



        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut))){

            String line = reader.readLine();

            while (line != null) {

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '?'
                            || line.charAt(i) == '!'
                            || line.charAt(i) == '.'
                            || line.charAt(i) == ',') {
                        punctuation++;
                    } else if (line.charAt(i) == 'a'
                            || line.charAt(i) == 'e'
                            || line.charAt(i) == 'i'
                            || line.charAt(i) == 'o'
                            || line.charAt(i) == 'u') {
                        vowels++;
                    } else if (Character.isAlphabetic(line.charAt(i))) {
                        if (line.charAt(i) != 'a'
                                || line.charAt(i) != 'e'
                                || line.charAt(i) != 'i'
                                || line.charAt(i) != 'o'
                                || line.charAt(i) != 'u') {
                            consonants++;
                        }
                    }
                }
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Punctuation: " + punctuation);

    }
}
