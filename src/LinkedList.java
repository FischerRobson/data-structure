public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void getHead() {
        System.out.println("Head: " + this.head);
    }

    public void getTail() {
        System.out.println("Head: " + this.tail);
    }

    public void getLength() {
        System.out.println("Head: " + this.length);
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.length++;
    }

    public Node removeLast() {
        if (this.length == 0) return null;

        Node temp = this.head;
        Node pre = this.head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        this.tail = pre;
        this.tail.next = null;
        length--;
        if (length == 0) {
            this.head = null;
            this.tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        length++;
    }
}
