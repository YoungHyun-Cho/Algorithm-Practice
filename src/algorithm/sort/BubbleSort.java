package algorithm.sort;

import java.util.Arrays;

public class BubbleSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        startFromFront(arr);
//        startFromBack(arr);
    }

    // 앞에서부터 버블정렬
    private void startFromFront(int[] arr) {

        for (int i = 0; i < arr.length; i++) { // i : 중첩 반복문에서 각 반복 시 어디까지 순회해야 하는지에 대한 정보 제공
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) swap(arr, j - 1, j);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    // 뒤에서부터 버블정렬
    private void startFromBack(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 2; j >= i; j--) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
