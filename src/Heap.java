import java.util.ArrayList;
import java.util.List;

// Its a binary tree but can have 2 or more equal elements, must be always complete
public class Heap {
    private List<Integer> heap;
    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = this.heap.get(index1);
        this.heap.set(index1, heap.get(index2));
        this.heap.set(index2, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int index = this.heap.size() - 1;

        while (index > 0 && this.heap.get(index) > this.heap.get(this.parent(index))) {
           this.swap(index, parent(index));
           index = parent(index);
        }
    }

}
