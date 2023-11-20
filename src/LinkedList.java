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
//        System.out.println();
//        for (int i = 0; i < this.length; i++) {
//            System.out.print(i + " || ");
//        }
//        System.out.println();
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

    public Node removeFirst() {
        if (this.length == 0) return null;
        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;
        if (length == 0) {
            this.tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= this.length) return null;
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
       Node temp = this.get(index);
       if (temp != null) {
           temp.value = value;
           return true;
       }
       return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > this.length) {
            return false;
        }
        if (index == 0) {
            this.prepend(value);
            return true;
        }
        if (index == this.length) {
            this.append(value);
            return true;
        }

        Node temp = this.get(index - 1);
        Node node = new Node(value);

        node.next = temp.next;
        temp.next = node;
        this.length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        if (index == 0) {
            return this.removeFirst();
        } if (index == this.length - 1) {
            return removeLast();
        }
        Node prev = this.get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    public void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
