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

    private void sinkDown(int index) {
        int maxIndex = index;

        while (true) {
            int leftIndex = this.leftChild(index);
            int rightIndex = this.rightChild(index);

            if (leftIndex < this.heap.size() && this.heap.get(leftIndex) > this.heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < this.heap.size() && this.heap.get(rightIndex) >  this.heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (index != maxIndex) {
                swap(index, maxIndex);
                index = maxIndex;
            } else return;
        }

    }

    public void insert(int value) {
        this.heap.add(value);
        int index = this.heap.size() - 1;

        while (index > 0 && this.heap.get(index) > this.heap.get(this.parent(index))) {
           this.swap(index, parent(index));
           index = parent(index);
        }
    }

    public Integer remove() {
        if (this.heap.isEmpty()) return null;
        if (this.heap.size() == 1) return this.heap.remove(0);

        int maxValue = this.heap.get(0);
        int lastValue = this.heap.remove(this.heap.size() - 1);

        this.heap.set(0, lastValue);

        sinkDown(0);

        return maxValue;
    }

}
