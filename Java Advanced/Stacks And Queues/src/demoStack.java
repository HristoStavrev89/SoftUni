import java.util.ArrayDeque;

public class demoStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> asd = new ArrayDeque<>();

        asd.push(20);
        asd.push(30);
        asd.push(40);
        asd.push(50);

        Integer pop =  asd.pop();
        System.out.println("Pop: " + asd.pop());

        Integer peek = asd.peek();
        System.out.println("Peek: " + asd.peek());

        int size = asd.size();
        boolean isEmpty = asd.isEmpty();
        boolean exists = asd.contains(20);

        System.out.println(asd.toString().replaceAll("[\\[\\],]",""));








    }
}
