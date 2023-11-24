public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(1);

        queue.enqueue(2);
        queue.enqueue(5);
        queue.dequeue();

        queue.printQueue();
    }
}