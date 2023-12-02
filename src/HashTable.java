import java.util.ArrayList;
import java.util.Objects;

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
            System.out.print("|" + i + "| ");

            Node temp = this.dataMap[i];
            while (temp != null) {
                System.out.print(" { " + temp.key + ": " + temp.value + " } ->");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % this.dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = this.hash(key);

        Node node = new Node(key, value);
        if (this.dataMap[index] == null) {
            this.dataMap[index] = node;
        } else {
            Node temp = this.dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public int get(String key) {
        int index = this.hash(key);

        Node temp = this.dataMap[index];
        while (temp != null) {
            if (Objects.equals(temp.key, key)) {
                return temp.value;
            } else {
                temp = temp.next;
            }
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            Node temp = this.dataMap[i];
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }
}
