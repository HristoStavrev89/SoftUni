import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class HighQualityMistakes {
    public static void main(String[] args) throws NoSuchFieldException {


        Field[] fields = Reflection.class.getDeclaredFields();

        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((Comparator.comparing(Field::getName)))
                .forEach(f -> {
                    System.out.println(String.format("%s must be private!"
                    , f.getName()));
                });


        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods).filter(m ->
                m.getName().startsWith("get") && m.getParameterCount() == 0)
                .filter(f -> !Modifier.isPublic(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Method[] setters = Arrays.stream(methods).filter(m ->
                m.getName().startsWith("set"))
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);



        Arrays.stream(getters).forEach(m -> {
            System.out.println(String.format("%s have to be public!",
                    m.getName()));
        });

        Arrays.stream(setters).forEach(m -> {
            System.out.println(String.format("%s have to be private!",
                    m.getName()));
        });


    }
}
