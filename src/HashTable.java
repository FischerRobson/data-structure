public class HashTable {
    private int size = 7;
    private Node[] dataMap; // a array of pointers to linked lists

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.dataMap = new Node[this.size];
    }

    public void printHashTable() {
        for (int i = 0; i < this.size; i++) {
            if (i != 0) System.out.println("---");
            System.out.println("|" + i + "|");

        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        System.out.println(keyChars);
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % this.dataMap.length;
        }
        return hash;
    }
}
