package algorithm.sort;

import java.util.Arrays;

/*
* # 셸 정렬
* - 단순 삽입 정렬의 장점을 살리면서, 단점을 보완
*   - 단순 삽입 정렬의 장점 : 정렬이 어느 정도 되어 있으면 속도가 빠름.
*   - 단순 삽입 정렬의 단점 : 삽입할 곳이 멀리 떨어져 있으면, 그 이후의 많은 요소들이 이동해야 함.
*
* - 원리
*   - 기존 삽입 정렬은 하나의 요소씩 순회 탐색하며, 정렬된 부분의 적절한 위치를 찾고, 해당 요소릅 삽입한 다음,
*     삽입한 자리 이후의 요소들을 모두 밀어냄.
*   - 셸 정렬은 결론적으로 단순 삽입 정렬을 마지막에 실행하기는 하지만, 그 전에 최대한 정렬된 상태와 가까운 상태로 만들어줌.
*     -> 결과적으로, 단순 삽입 정렬의 장점을 잘 살릴 수 있게 됨.
*
* - 그렇다면, 어떻게 최대한 정렬된 상태와 가깝게 만들까?
*   - gap을 사용해 대충이라도 적은 비용으로 정렬하는 과정을 거침.
*       - gap : 비교하고자 하는 요소까지의 거리를 의미함.
*       - gap 번째부터 배열 마지막까지 순회하면서, -> i로 순회
*           - 특정 요소의 인덱스 - (gap * n) 번째 요소와 i번째 요소를 비교함.
*               - 예 : arr.length == 10, gap = 4 -> i = 4~9
*                   - i가 4일 때 j : 0
*                   - i가 5일 때 j : 1
*                   - i가 6일 때 j : 2
*                   - i가 7일 때 j : 3
*                   - i가 8일 때 j : 4, 0
*                   - i가 9일 때 j : 5, 1
*               - 즉,
*                   - i: 4, j: 0    ->  4 <-> 0 비교
*                   - i: 5, j: 1    ->  5 <-> 1 비교
*                   - i: 6, j: 2    ->  6 <-> 2 비교
*                   - i: 7, j: 3    ->  7 <-> 3 비교
*                   - i: 8, j: 4, 0 ->  8 <-> 4, 4 <-> 0 비교
*                   - i: 9, j: 5, 1 ->  9 <-> 5, 5 <-> 1 비교
*       - 🟥 정리하면, gap 간격 만큼 앞선 위치의 요소와 자기 자신을 비교하고, 값이 작으면 자리를 바꿈.
*
* - 이러한 과정을 거치다 gap이 1이 되면,
*   - 이미 배열은 어느 정도 정렬된 상태가 됨.
*   - 그 상태에서 단순 삽입 정렬이 실행됨.
*
* - gap의 값 : 3의 배수 + 1에 해당하는 수열 중에서 && arr.length보다 작은 값
*   - 왜 3의 배수 + 1에 해당하는 수열 중에서 선택?
*       - gap을 통해 서로 비교되는 수들을 그룹화한다고 할 수 있음.
*       - 이 때, gap으로 그룹화되는 수들은 gap의 값이 바뀜에 따라 적절히 섞여야 함.
*           - gap의 값의 수열이 서로 배수가 된다면 비교되는 그룹 내의 요소들은 gap의 값이 변해도
*             다른 값들과 같은 그룹으로 섞일 수 없음.
*             -> 결과적으로 셸 정렬의 효율이 저하됨.
* */

public class ShellSort implements SortAlgorithm {

    @Override
    public void test(int[] arr) {

    }


















    @Override
    public void sort(int[] arr) {

//        System.out.println(Arrays.toString(arr));

        /*
        * gap의 값을 구해줌.
        * gap 값은 이후 계속 감소하는 방향으로 변화할 것이며, gap 값의 수열은 서로 배수가 되지 않도록 구성해야 함.
        * 그를 위한 방법 중의 하나가 gap의 값을 초기에 3의 배수에 1을 더한 값으로 gap을 설정해주고(gap = gap * 3 + 1),
        * 이후에 3을 나눈 몫으로 gap을 감소시키는 것임(gap /= 3).
        * 예 : ... 40, 13, 4, 1 -> 서로 배수가 되지 않음.
        * */
        int gap;
        for (gap = 1; gap < arr.length; gap = gap * 3 + 1 );

        while (gap > 0) {                                              // gap의 값을 감소시키기 위한 while문
            for (int i = gap; i < arr.length; i++) {                   // for문은 단순 삽입정렬의 흐름과 동일함.
                int j;                                                 // 삽입 정렬에서 선언한 j와 같은 역할
                int temp = arr[i];                                     // 삽입 정렬에서 선언한 temp와 같은 역할
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) { // 🟥 아래 참고
                    arr[j + gap] = arr[j];                             // temp의 인덱스에서부터 0까지 gap만큼 j를 감소시키며
                }                                                      // arr[j]를 삽입할 적절한 위치를 찾고 삽입
                arr[j + gap] = temp;                                   // 삽입 정렬에서의 코드와 동일
//                System.out.println(Arrays.toString(arr));
            }
            gap /= 3;                                                  // gap 값을 3으로 나눔.
        }
    }
}

/*
* 🟥 참고
* - 삽입 정렬에서는, 특정 요소(arr[i])를 정렬된 요소들의 집합(arr[0]~arr[i-1]) 중 어디에 삽입할 것인지를 정할 때,
*   정렬된 요소들의 집합을 하나하나 역순으로 탐색하며 탐색했음. -> j--
* - 셸 정렬에서는, gap이 1보다 클 때에는 gap만큼 감소시키며 탐색함. -> j -= gap
*   - 삽입 정렬 전 대충으로라도 정렬하는 과정임.
* */
