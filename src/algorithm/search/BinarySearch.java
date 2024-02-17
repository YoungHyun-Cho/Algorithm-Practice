package algorithm.search;

public class BinarySearch implements SearchAlgorithm {
    @Override
    public int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int center;

        while (left <= right) {
            center = (right + left) / 2;
            if (key < arr[center]) right = center - 1;
            else if (arr[center] < key) left = center + 1;
            else return center;
        }

        return -1;
    }
}
