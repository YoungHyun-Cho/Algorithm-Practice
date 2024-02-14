package algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    public static int[] arr = new int[] {
            3, 11, 0, 13, 1, 2, 9, 17, 6, 16,
            5, 19, 8, 4, 18, 12, 14, 7, 10, 15
    };
    public static SortAlgorithm sortAlgorithm = new BubbleSort();

    @Test
    public void sortTest() {

        sortAlgorithm.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], i);
        }
    }
}
