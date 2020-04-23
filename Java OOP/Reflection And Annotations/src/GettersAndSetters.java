import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class GettersAndSetters {
    public static void main(String[] args) {


        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods).filter(m ->
                m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);


        Method[] setters = Arrays.stream(methods).filter(m ->
                m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);




        Arrays.stream(getters).forEach(m -> {
            System.out.println(String.format("%s will return class %s",
                    m.getName(), m.getReturnType().getSimpleName()));
        });


        Arrays.stream(setters).forEach(m -> {
            System.out.println(String.format("%s and will field of class %s",
                    m.getName(), m.getReturnType().getSimpleName()));
        });

    }
}
