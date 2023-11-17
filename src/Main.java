public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(3);
        linkedList.append(6);
        linkedList.append(9);

        linkedList.prepend(8);
        //linkedList.removeFirst();
        //linkedList.removeLast();

        System.out.println(linkedList.get(1).value);

        linkedList.printList();
    }
}