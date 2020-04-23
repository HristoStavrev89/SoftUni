package ArrayCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayCreator {

    public static <T> T[] create (int length, T item) {

        Object[] asd = new Object[length];

        for (int i = 0; i < length; i++) {
            asd[i] = item;
        }

        return (T[]) asd;

    }


    public static <T> T[] create(Class<T> tclass, int length, T item) {

        T[] o = (T[]) Array.newInstance(tclass, length);

        for (int i = 0; i < o.length; i++) {
            o[i] = item;
        }

        return o;
    }

}
