public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node node = new Node(value);
        this.first = node;
        this.last = node;
        this.length = 1;
    }

    public void printQueue() {
        Node temp = this.first;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }

    public void getFirst() {
        System.out.println("First: " + this.first.value);
    }

    public void getLast() {
        System.out.println("Last: " + this.last.value);
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.first = node;
        } else {
            this.last.next = node;
        }
        this.last = node;
        this.length++;
    }

    public Node dequeue() {
        if (this.length == 0) return null;
        Node temp = this.first;
        this.first = this.first.next;
        temp.next = null;
        if (this.length == 1) this.last = null;
        this.length--;
        return temp;
    }

}
