// Binary Search Tree
public class Tree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Tree() {}

    public boolean insert(int value) {
        Node node = new Node(value);
        if (this.root == null) {
            this.root = node;
            return true;
        }

        Node temp = this.root;
        
        while (true) {
            if (temp.value == node.value) {
                return false;
            }
            if (node.value < temp.value) {
                if (temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public void printTree() {
        System.out.println(TreeFormatter.topDown(this.root));
    }

    public boolean contains(int value) {
        if (this.root == null) return false;
    }

}
