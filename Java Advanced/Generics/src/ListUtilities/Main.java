package ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> asd = new ArrayList<>();



        asd.add(1);
        asd.add(10);
        asd.add(100);
        asd.add(1000);
        asd.add(4234);
        asd.add(-2);

        System.out.println(ListUtils.getMin(asd));

        System.out.println(ListUtils.getMax(asd));




    }
}
