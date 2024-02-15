import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = Arrays.copyOf(array, array.length);
        int[] array4 = Arrays.copyOf(array, array.length);

        int[] array5 = {4, 6, 1, 7, 3, 2, 5};

        Sort.bubbleSort(array);
        Sort.selectionSort(array2);
        Sort.insertionSort(array3);
        Sort.pivot(array5, 0, array5.length);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(Sort.mergeSort(array4)));
        System.out.println(Arrays.toString(array5));
    }
}