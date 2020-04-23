import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        doSomething(5);
    }

    private static void doSomething(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        doSomething(--n);
    }
}
