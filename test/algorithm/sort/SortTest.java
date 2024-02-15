package algorithm.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    private static int[] arr;
    private static SortAlgorithm sortAlgorithm = new QuickSort();
    private static int testArraySize = 20;

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
    }

    @Test
    public void sortTest() {

        long start = System.nanoTime();
        sortAlgorithm.sort(arr);
        long end = System.nanoTime();

        for (int i = 0; i < testArraySize; i++) {
            assertEquals(arr[i], i);
        }

        System.out.println("소요 시간 : " + (end - start));
    }
}
