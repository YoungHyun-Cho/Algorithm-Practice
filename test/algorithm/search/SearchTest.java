package algorithm.search;

import algorithm.sort.HeapSort;
import algorithm.sort.QuickSort;
import algorithm.sort.SortAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

    private static int[] arr;

    private static SortAlgorithm sortAlgorithm = new QuickSort();
    private static SearchAlgorithm searchAlgorithm = new BinarySearch();
    private static final int testArraySize = 10000;
    private static final int ANSWER = 7777;

    @BeforeEach
    public void initiateArray() {

        // 0 ~ testArraySize 까지의 배열 생성
        int[] shuffled = new int[testArraySize];
        for (int i = 0; i < shuffled.length; i++) {
            shuffled[i] = i;
        }

        // 순서 섞기
        Random random = new Random();
        for (int i = shuffled.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);

            // swap
            int temp = shuffled[randomIndex];
            shuffled[randomIndex] = shuffled[i];
            shuffled[i] = temp;
        }

        arr = shuffled;
        sortAlgorithm.sort(arr);
    }

    @Test
    public void searchTest() {

        long start = System.nanoTime();
        assertEquals(ANSWER, searchAlgorithm.search(arr, arr[ANSWER]));
        assertEquals(-1, searchAlgorithm.search(arr, -12412123));
        long end = System.nanoTime();

        System.out.println("소요 시간 : " + (end - start));
    }
}
