package algorithm.sort;

import java.util.Arrays;

/*
* # 버블 정렬
* - 인접한 요소(좌, 우)들을 비교하고, 우측 요소보다 좌측 요소가 더 크다면, 양 요소의 자리를 바꿈(swap).
* - 외부반복문이 1회 순회할 때마다,
*   - 가장 큰 요소가 우측으로 밀림.
*   - 따라서, 내부반복문의 다음 순회에서는 직전 순회 종료 시점 이전까지만 반복 비교 작업을 진행
*
* - 맨 앞에서부터 시작할 수도 있고, 맨 뒤에서부터 시작할 수도 있음.
*   - 맨 앞에서부터 시작 : 외부반복문 매 순회마다 큰 요소들이 우측으로 모임.
*   - 맨 뒤에서부터 시작 : 외부반복문 매 순회마다 작은 요소들이 좌측으로 모임.
* */

public class BubbleSort implements SortAlgorithm {

    @Override
    public void test(int[] arr) {

    }















    @Override
    public void sort(int[] arr) {
//        System.out.println(Arrays.toString(arr));
        startFromFront(arr);
//        startFromBack(arr);
    }

    // 앞에서부터 버블정렬
    private void startFromFront(int[] arr) {

        for (int i = 0; i < arr.length; i++) {                    // i : 중첩 반복문에서 각 반복 시 어디까지 순회해야 하는지에 대한 정보 제공 (length - i까지 증가)
            for (int j = 1; j < arr.length - i; j++) {            // 맨 앞에서부터 length - 1까지 두 요소를 비교하기 위해 순회
                if (arr[j - 1] > arr[j]) swap(arr, j - 1, j); // j와 j 직전 요소를 비교하고, 직전 요소가 더 크다면 서로 자리를 바꿈.
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    // 뒤에서부터 버블정렬
    private void startFromBack(int[] arr) {

        for (int i = 0; i < arr.length; i++) {                     // i : 중첩 반복문에서 각 반복 시 어디까지 순회해야 하는지에 대한 정보 제공 (i까지 감소)
            for (int j = arr.length - 2; j >= i; j--) {            // 맨 뒤에서부터 i까지 두 요소를 비교하기 위해 순회
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1); // j와 j 직후 요소를 비교하고, 직후 요소가 더 크다면 서로 자리를 바꿈.
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
