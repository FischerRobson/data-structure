import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        Node temp = this.root;

        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value){
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean recursiveContains(int value) {
        return recursiveContains(this.root, value);
    }

    private boolean recursiveContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return recursiveContains(currentNode.left, value);
        } else {
            return recursiveContains(currentNode.right, value);
        }
    }

    public void recursiveInsert(int value) {
        if (this.root == null) this.root = new Node(value);
        recursiveInsert(this.root, value);
    }

    private Node recursiveInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);
        if(value < currentNode.value) {
            currentNode.left = recursiveInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = recursiveInsert(currentNode.right, value);
        }
        return currentNode;
    }

    private int findSmallerValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value) {
        this.deleteNode(this.root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            // handle the value in the tree
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            }  else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = findSmallerValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode, subTreeMin);
            }
        }
        return currentNode;
    }

    public int getHeight() {
        return this.getHeight(this.root) - 1;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = this.getHeight(node.left);
        int rightHeight = this.getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Tree Traversal

    public ArrayList<Integer> BFS() {
        Node currentNode = this.root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        return results;
    }


    // runs down to left
    // Every time new Traverse is called its go to call stack
    // So the root right node will be only add in stack after all
    // deep in left node was iterated.
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(this.root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }
        new Traverse(this.root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(this.root);
        return results;
    }
}
