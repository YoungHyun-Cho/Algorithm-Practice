package algorithm.search;

public class LinearSearch implements SearchAlgorithm {
    @Override
    public int search(int[] arr, int key) {

        int i;
        for (i = 0; i < arr.length && arr[i] != key; i++);

        return i == arr.length ? -1 : i;
    }
}
