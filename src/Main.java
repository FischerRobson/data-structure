public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(1);

        dll.append(7);
        dll.append(5);
        dll.append(10);
        dll.append(1);


        dll.removeLast();

        dll.prepend(9);
        dll.prepend(2);

//        dll.removeFirst();
//        dll.removeFirst();

        dll.printList();

        dll.remove(2);

        dll.printList();

//        dll.set(3, 10);
//
//        dll.printList();

//        System.out.println(dll.get(4).value);
    }
}