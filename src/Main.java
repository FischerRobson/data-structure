public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(5);
        tree.insert(12);
        tree.insert(15);
        tree.insert(90);
        tree.insert(42);
        tree.insert(8);

        tree.printTree();
    }
}