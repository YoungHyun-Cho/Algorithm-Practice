package algorithm.sort;

import java.util.Arrays;

public class SelectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            swap(arr, i, minIndex);
            System.out.println(Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
