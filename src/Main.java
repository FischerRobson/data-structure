public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.set("Messi", 10);
        hashTable.set("Ronaldo", 7);
        hashTable.set("Sergio R.", 4);
        hashTable.set("Neuer", 1);
        hashTable.set("Khvicha", 77);
        hashTable.set("Anguissa", 99);
        hashTable.set("Harry Kane", 9);
        hashTable.set("Goretzka", 8);
        hashTable.set("Kimmich", 6);
        hashTable.set("Davies", 19);
        hashTable.set("Reus", 11);
        hashTable.set("Lobotka", 68);
        hashTable.set("Zielinsky", 20);

        hashTable.printHashTable();

        System.out.println(hashTable.keys());
    }
}