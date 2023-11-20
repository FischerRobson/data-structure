public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(3);
        linkedList.append(6);
        linkedList.append(9);

        linkedList.prepend(8);
        //linkedList.removeFirst();
        //linkedList.removeLast();

        linkedList.insert(2, 8);

        linkedList.set(0, 7);

        linkedList.remove(4);

        linkedList.printList();

        linkedList.reverse();
        linkedList.printList();
    }
}