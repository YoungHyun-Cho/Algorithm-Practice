package algorithm.sort;

import java.util.Arrays;

public class InsertionSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {

        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }
}