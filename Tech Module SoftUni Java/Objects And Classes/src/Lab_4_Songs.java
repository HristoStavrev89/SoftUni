import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab_4_Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<String> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] data = scanner.nextLine().split("_");


            String type = data[0];
            String name = data[1];
            String time = data[3];




        }





    }
    public class Song {
        private String typeList;
        private String name;
        private String time;



        public String getTypeList () {
            return typeList;
        }
        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }




        public String getName() {
            return name;
        }
        public void setNameList(String name) {
            this.name = name;
        }


        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }

    }

}
