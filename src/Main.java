public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(47);
        tree.insert(21);
        tree.insert(77);
        tree.insert(18);
        tree.insert(27);
        tree.insert(52);
        tree.insert(82);

        tree.printTree();

        System.out.println("Breadth-First Search: " + tree.BFS());
        System.out.println("Deep First Search Pre Order: " + tree.DFSPreOrder());
        System.out.println("Deep First Search Post Order: " + tree.DFSPostOrder());
        System.out.println("Deep First Search In Order: " + tree.DFSInOrder());
    }
}