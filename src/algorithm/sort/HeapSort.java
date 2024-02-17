package algorithm.sort;

/*
* # 힙 정렬
* - 힙 : 부모 노드 값이 자식 노드 값보다 크거나 같은 완전 이진 트리
*   - 완전 이진 트리
*       - 완전 : 부모가 자식을 추가할 때 왼쪽부터 추가함.            9
*       - 이진 : 부모가 가질 수 있는 자식의 수가 최대 2개         7    8
*   - 형제 노드 사이의 관계는 관련 없음.                     5    6    4
*
* - 원리
*   - 기본적으로 선택 정렬을 응용한 정렬 방법
*       - 선택 정렬 : 최소값을 선택하여 맨 앞으로 차례대로 빼냄.
*       - 힙 정렬 : 반대로, 힙을 이용하여 최대 값을 선택하여 맨 뒤로 빼냄.
*
* - 공식
*   - 우측의 힙은 아래의 배열과 같이 나타낼 수 있음.                    10
*       - arr : [ 10, 9, 5, 8, 3, 2, 4, 6, 7, 1 ]         9       5
*   - i번째 요소의 부모 :      arr[(i - 1) / 2]           8    3    2    4
*   - i번째 요소의 왼쪽 자식 :  arr[i * 2 + 1]          6    7    1
*   - i번째 요소의 오른쪽 자식 : arr[i * 2 + 2]
*
* - 예
*   - 2의 부모 :      arr[5 - 1 / 2] = arr[2] => 5
*   - 8의 왼쪽 자식 :  arr[3 * 2 + 1] = arr[7] => 6
*   - 8의 오른쪽 자식 : arr[3 * 2 + 2] = arr[8의 왼쪽 자식 인덱스 + 1] = arr[8] => 7
* */

public class HeapSort implements SortAlgorithm {

        @Override
    public void sort(int[] arr) {                   // arr : [ 10, 9, 5, 8, 3, 2, 4, 6, 7, 1 ]
        final int LAST_INDEX = arr.length - 1;

        // arr[i]~arr[LENGTH-1]을 힙으로 만듦.
        for (int i = LAST_INDEX / 2; i >= 0; i--) { // i : 4->3->2->1->0 => 1️⃣ 참고
            composeHeap(arr, i, LAST_INDEX);        // 4~9 -> 3~9 -> 2~9 -> 1~9 -> 0~9
        }

        for (int i = LAST_INDEX; i > 0; i--) {       // 이 반복문에 진입 -> 이미 힙이 구성되어 있음
            swap(arr, 0, i);                         // 루트(최대값)와 맨 뒤의 값을 교환
            composeHeap(arr, 0, i - 1);              // 맨 뒤값을 제외하고 다시 힙 구성
        }
    }

    private static void composeHeap(int[] arr, int left, int right) {   // arr[left]~arr[right]를 힙으로 만듦.
        int temp = arr[left];                                           // 힙 구성 전 루트에 위치하는 요소를 일시로 저장
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) { // 2️⃣ 참고
            int cl = parent * 2 + 1;                                    // 왼쪽 자식 노드
            int cr = cl + 1;                                            // 오른쪽 자식 노드

            child = cr <= right && arr[cl] < arr[cr] ? cr : cl;         // 3️⃣ 참고

            if (temp >= arr[child]) break;                              // 일시 저장해 둔 값이 자식 노드의 값보다 크면 순회 중지
            else arr[parent] = arr[child];                              // 그렇지 않으면, 부모 노드에 더 큰 값을 넣어줌.
        }

        arr[parent] = temp;                                             // 증가한 parent의 값은 temp가 들어가야 할 리프노드를 가리키게 됨.
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

/*
* 1️⃣ : i의 값을 LAST_INDEX / 2로 설정하여 1씩 감소시키는 이유
*       - 마지막 노드의 부모 노드는 LAST_INDEX / 2에 있음.
*           - arr : [ 10, 9, 5, 8, 3, 2, 4, 6, 7, 1 ]에서,
*               - 마지막 노드 : 1, 부모 노드 : 3
*       - 마지막 노드부터 힙을 구성하고, i를 감소시켜 숫자를 하나씩 힙에 추가하여 재구성함.
*
* 2️⃣ : for (parent = left; parent < (right + 1) / 2; parent = child) { ... }
*       - parent = left : left는 루트의 자리 -> 이후 arr[left] ~ arr[right]의 값 중 최대값으로 채워질 예정
*       - parent < (right + 1) / 2 : 부모 노드가 리프 노드가 되지 않도록 함.
*           - 예 : left : 0, right : 9 -> (right + 1) / 2 = 5 -> arr[5]는 2
*               - 트리 상, arr[5] 이전은 모두 부모 노드, arr[5]부터는 리프노드임.
*               - 힙의 구조로부터 유도할 수 있는 식임.
* 3️⃣ : child = cr <= right && arr[cl] < arr[cr] ? cr : cl;
*       - 왼쪽 자식 노드와 오른쪽 자식 노드 중 큰 값의 인덱스를 child에 저장
*       - cr <= right : 오른쪽 자식 노드가 존재하는지 확인
*           - 왜 확인? -> 힙에서 오른쪽 자식 노드는 없을 수도 있음.
*           - 왼쪽 노드는 왜 확인안하지? -> 반복문 조건 parent < (right + 1) / 2로 인해 parent는 부모 노드의 인덱스만 탐색함.
*               - 10, 9, 5, 8, 3과 같은 부모 노드들은 자식을 2개 가지거나 1개 가질 수 있음.
*                   - 0개 가지는 경우는 없음. 자식이 0개면 부모가 아니라 리프니까.
*           - 따라서, 어떤 노드가 부모 노드라면 왼쪽 자식 노드는 반드시 존재하므로 확인할 필요가 없음.
*             하지만, 오른쪽 자식 노드는 존재하지 않을 수도 있기 때문에 cr <= right를 통해서 확인할 필요가 있음.
*
 * */