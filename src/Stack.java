public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node node = new Node(value);
        this.top = node;
        this.height = 1;
    }

    public void printStack() {
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.value);
            System.out.println("⬇️");
            temp = temp.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + this.top);
    }

    public void getHeight() {
        System.out.println("Height: " + this.height);
    }

    public void push(int value) {
        Node node = new Node(value);
        if (this.height == 0) {
            this.top = node;
        } else {
            node.next = this.top;
            this.top = node;
        }
        this.height++;
    }

    public Node pop() {
        if (this.height == 0) return null;

        Node temp = this.top;
        this.top = this.top.next;
        temp.next = null;

        this.height--;
        return temp;
    }
}
