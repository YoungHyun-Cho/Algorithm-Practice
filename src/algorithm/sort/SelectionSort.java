package algorithm.sort;

import java.util.Arrays;

/*
* # 선택 정렬
* - 외부 반복문으로 자리를 지정하고, 해당 자리 이후에 존재하는 최소값을 지정한 자리의 값과 바꿈(swap)
* - 내부 반복문으로 해당 자리 이후의 최소값을 탐색해야 함.
* */

public class SelectionSort implements SortAlgorithm {

    @Override
    public void test(int[] arr) {

    }















    @Override
    public void sort(int[] arr) {

//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {            // i : 최소값이 곧 들어올 자리 지정
            int minIndex = i;                             // minIndex : 최소값이 존재하는 자리
            for (int j = i + 1; j < arr.length; j++) {    // 최소값을 찾기 위해 i 바로 다음부터 배열 순회
                if (arr[j] < arr[minIndex]) minIndex = j; // 최소값을 찾아 minIndex에 위치 저장
            }
            swap(arr, i, minIndex);                       // 처음에 지정한 자리(i)와 최소값이 존재하는 위치의 값을 서로 바꿈
//            System.out.println(Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
