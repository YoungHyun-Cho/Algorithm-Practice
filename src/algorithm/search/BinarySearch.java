package algorithm.search;

public class BinarySearch implements SearchAlgorithm {
    @Override
    public int search(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;
        int center;

        while (left <= right) {
            center = (left + right) / 2;
            if (arr[center] == key) return center;
            else if (arr[center] > key) right = center - 1;
            else left = center + 1;
        }
        return -1;
    }
}
