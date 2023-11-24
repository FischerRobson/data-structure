public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print("<- " + temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println();
        for (int i = 0; i < this.length; i++) {
            System.out.print("|| " + i + " || ");
        }
        System.out.println();
    }

    public void getHead() {
        System.out.println("Head: " + this.head);
    }

    public void getTail() {
        System.out.println("Tail: " + this.tail);
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }

    public void append(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = node;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
        }
        this.tail = node;
        this.length++;
    }

    public Node removeLast() {
        if (this.length == 0) return null;

        Node temp = this.tail;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.length++;
    }

    public Node removeFirst() {
        if (this.length == 0) return null;

        Node temp = this.head;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
            temp.next = null;
        }

        this.length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= this.length) return null;

        Node temp = this.head;

        if (index < this.length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= this.length) return false;
        Node node = this.get(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > this.length) return false;
        if (index == 0) {
            this.prepend(value);
            return true;
        }
        if (index == this.length) {
            this.append(value);
            return true;
        }

        Node node = new Node(value);

        Node before = this.get(index - 1);
        Node after = before.next;

        node.next = after;
        node.prev = before;

        before.next = node;
        after.prev = node;
        this.length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) return null;
        if (index == 0) {
            return this.removeFirst();
        }
        if (index == this.length - 1) {
            return this.removeLast();
        }
        Node temp = this.get(index);
        Node before = temp.prev;
        Node after = temp.next;

        before.next = after;
        after.prev = before;

        this.length--;
        return temp;
    }
}
