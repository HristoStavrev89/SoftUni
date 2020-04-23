import java.util.ArrayDeque;

public class demoQueue {
    public static void main(String[] args) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();


        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.push(70);

        System.out.println(queue);
        System.out.println("Peak: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Peak: " + queue.peek());
        System.out.println("Poll: " + queue.poll());



    }
}
