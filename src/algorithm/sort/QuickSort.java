package algorithm.sort;

/*
* # 퀵 정렬
* - 기본적으로 분할정복 알고리즘이 적용됨.
*   - 피벗보다 작은 값을 피벗 좌측으로, 피벗보다 큰 값을 피벗 우측으로 이동시킴.
*   - 피벗을 기준으로 좌측, 우측을 각각의 그룹으로 나누어(분할) 위의 과정을 반복(정복)해서 진행
*
* - 원리
*   - 피벗을 정하고, 좌우끝에서 피벗을 향해 스캔함.
*       - 좌끝 -> 피벗 : 피벗보다 큰값을 발견하면 스캔 멈춤.
*       - 우끝 -> 피벗 : 피벗보다 작은 값을 발견하면 스캔 멈춤.
*   - 스캔을 멈춘 자리에서, 각 값을 교환함. (swap)
*   - 이후, 피벗을 기준으로 좌우를 그룹으로 나누어 각각의 그룹에서 동일한 과정을 반복함.
*       - 각 그룹에 하나의 요소만 남을 때까지
* */
public class QuickSort implements SortAlgorithm {

    @Override
    public void test(int[] arr) {

    }






















    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pl = left;                                             // 왼쪽 스캔 포인터
        int pr = right;                                            // 오른쪽 스캔 포인터
        int pivot = arr[(pl + pr) / 2];                            // 피벗 : 중간에 위치한 값으로 지정

        while (pl <= pr) {                                         // 피벗이 교차하지 않는 동안에만 반복 -> 교차 시 멈춤
            while (arr[pl] < pivot) pl++;                          // 좌측에서부터 피벗까지 스캔하며, 피벗보다 큰 값이 나오면 스캔 멈춤.
            while (arr[pr] > pivot) pr--;                          // 우측에서부터 피벗까지 스캔하며, 피벗보다 작은 값이 나오면 스캔 멈춤.
            if (pl <= pr) swap(arr, pl++, pr--);                   // 두 값을 교환함. 이 때, 피벗은 서로 교차하지 않은 상태여야 함.
        }

        if (left < pr) quickSort(arr, left, pr);                   // 피벗 기준 좌측 그룹에 대해 동일한 작업 수행
        if (pl < right) quickSort(arr, pl, right);                 // 피벗 기준 우측 그룹에 대해 동일한 작업 수행
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
