package algorithm.sort;

/*
* # 병합 정렬
* - 기본적으로 분할정복 알고리즘 적용
*   - 배열을 나누고, 아래의 병합 방법을 적용하여 정렬함. → 재귀적으로 실행
*
* - 병합 방법
*   - 배열을 둘로 나누고, 두 배열 A, B의 맨 앞 요소 중에서 작은 요소를 새로운 배열 C에 추가함.
*   - 이를 A, B 중 하나가 끝날 때까지 반복
*   - A, B 중 하나가 끝나면 나머지 배열의 남은 요소를 C의 마지막에 넣어줌.
*
* - 아래 구현 코드에서는 새로운 배열 C를 사용하는 대신, 포인터와 버퍼를 사용함.
*   - 버퍼
*       - 좌우로 나눈 그룹 중 좌측 그룹을 버퍼에 저장
*       - 이후, 버퍼와 우그룹을 비교하여 작은 값을 좌그룹 자리에 저장해줌.
*       - 즉, 일종의 배열에 대한 temp 변수처럼 동작
*   - 포인터
*       - ap1 : arr 포인터 1
*       - ap2 : arr 포인터 2
*       - bp1 : 버퍼 포인터 1
*       - bp2 : 버퍼 포인터 2
* */

public class MergeSort implements SortAlgorithm {

    @Override
    public void test(int[] arr) {

    }

















    @Override
    public void sort(int[] arr) {
//        buffer = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1);
//        buffer = null;
    }

//    private static void mergeSort(int[] arr, int left, int right) {
//        if (left < right) {                  // 재귀 종료 조건
//            int ap1 = left;                  // arr 포인터 1 -> 좌끝으로 초기화
//            int ap2 = left;                  // arr 포인터 2 -> 좌끝으로 초기화
//            int bp1 = 0;                     // 버퍼 포인터 1 -> 0으로 초기화
//            int bp2 = 0;                     // 버퍼 포인터 2 -> 0으로 초기화
//            int center = (left + right) / 2; // 그룹화를 위한 중간 지점
//
//            mergeSort(arr, left, center);          // 좌끝~센터 그룹에 대해 재귀적으로 분할
//            mergeSort(arr, center + 1, right); // 센터+1~우끝 그룹에 대해 재귀적으로 분할
//
//            while (ap1 <= center) {                // 1️⃣ 좌끝~센터까지의 요소를 버퍼로 복사
//                buffer[bp1++] = arr[ap1++];
//            }
//
//            while (ap1 <= right && bp2 < bp1) {    // 2️⃣ arr[센터+1~우끝]의 요소와 버퍼의 요소들 중, 작은 요소를 arr의 좌끝에 복사
//                arr[ap2++] = buffer[bp2] <= arr[ap1] ? buffer[bp2++]: arr[ap1++]; // 복사한 대상의 인덱스를 1 증가 (포인터 수정)
//            }
//
//            while (bp2 < bp1) {                    // 3️⃣ 버퍼에 남은 요소들을 arr에 이어서 복사
//                arr[ap2++] = buffer[bp2++];
//            }
//        }
//    }
}

/*
* # 동작 예시
* arr : [   8   6   4   3   2   9   5   0   1   7   ]
*
* 1. 분할
*   - 분할 단계
*       - 1단계 : [   8   6   4   3   2   ], [   9   5   0   1   7   ]
*       - 2단계 : [   8   6   4   ], [   3   2   ], [   9   5   0   ], [   1   7   ]
*       - 3단계 : [   8   6   ], [   4   ], [   3   2   ], [   9   5   ], [   0   ], [   1   7   ]
*       - 4단계 : [   8   ], [   6   ], [   4   ], [   3   ], [   2   ], [   9   ], [   5   ], [   0   ], [   1   ], [   7   ]
*   - 이 때, 3, 4단계에서 하나로 분할된 배열은 재귀 조건인 left < right를 충족하지 못함. (left == right)
*       - 따라서, 3단계의 [   8   6   ]부터 정복 과정을 시작함.
*
* 2. 정복
*   2.1. arr : [   8   6   ...   ]   /   buffer : [   _   _   _   ...   ]
*                  ⬆                                 ⬆
*                 ap1                                bp1
*                 ap2                                bp2
*
*   - 1️⃣ : arr의 좌측 요소가 모두 버퍼로 복사됨. (ap1 <= center -> 0 <= 0)
*       - buffer[bp1++] = arr[ap1++];
*        arr : [   8   6   ...   ]   /   buffer : [   8   _   _   ...   ]
*                  ⬆  ⬆                              ⬆  ⬆
*                 ap2 ap1                            bp2 bp1
*       - ap1 : arr로부터 버퍼로 복사한 요소의 갯수 & 다음 이동 대상 인덱스 의미 포함
*       - bp1 : 버퍼로 복사된 요소의 갯수 & 다음 빈 버퍼 자리 인덱스 의미 포함
*
*   - 2️⃣ : 센터+1 ~ 우끝의 요소 중 작은 값이 arr의 좌끝 요소 이후로 복사됨. (센터+1 == ap1 -> ap1 <= right -> 1 <= 1)
*       - arr[ap2++] = buffer[bp2] <= arr[ap1] ? buffer[bp2++]: arr[ap1++];
*        arr : [   6   6   ...   ]   /   buffer : [   8   _   _   ...   ]
*                      ⬆  ⬆                          ⬆  ⬆
*                     ap2 ap1                        bp2 bp1
*       - ap1이 가리키는 요소가 bp2가 가리키는 요소보다 작으므로 ap2가 가리키는 위치에 복사
*       - 복사 후, ap1과 ap2를 1씩 증가
*
*   - 3️⃣ : 버퍼에 잔여하는 요소들을 모두 arr로 복사 (bp2 < bp1 -> 0 < 1)
*       - arr[ap2++] = buffer[bp2++];
*        arr : [   6   8   ...   ]   /   buffer : [   8   _   _   ...   ]
*                          ⬆                             ⬆
*                         ap1                            bp1
*                         ap2                            bp2
*
*   2.2. arr : [   6   8   4   ...   ]   /   buffer : [   _   _   _   ...   ]
*                  ⬆                                     ⬆
*                 ap1                                    bp1
*                 ap2                                    bp2
*
*   - 1️⃣ : ap1 <= center -> 0 <= 1
*       - buffer[bp1++] = arr[ap1++];
*        arr : [   6   8   4   ...   ]   /   buffer : [   6   8   _   ...   ]
*                  ⬆      ⬆                              ⬆      ⬆
*                 ap2     ap1                            bp2     bp1
*
*   - 2️⃣ : ap1 <= right && bp2 < bp1 -> 2 <= 2 && 0 < 2
*       - arr[ap2++] = buffer[bp2] <= arr[ap1] ? buffer[bp2++]: arr[ap1++];
*        arr : [   4   8   4   ...   ]   /   buffer : [   6   8   _   ...   ]
*                      ⬆       ⬆                         ⬆      ⬆
*                     ap2      ap1                       bp2     bp1
*
*   - 3️⃣ : bp2 < bp1 -> 0 -> 2
*       - arr[ap2++] = buffer = [bp2++]
*        arr : [   4   6   8   ...   ]   /   buffer : [   6   8   _   ...   ]
*                               ⬆                                ⬆
*                              ap1                               bp1
*                              ap2                               bp2
*
* 3. 반복
*   - '2. 분할'과 '3. 정복' 과정을 재귀적으로 반복함.
* */