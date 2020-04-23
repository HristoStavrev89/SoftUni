public class Rectangle_of_Stars {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            System.out.println(repeatStr("*",10));
        }

    }
    static String repeatStr (String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count ; i++) {
            result.append(text);
        }
        return result.toString();
    }

}
