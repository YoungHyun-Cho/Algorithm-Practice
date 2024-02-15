package algorithm.sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTimeTest {
    private static int[] arr;
    private static int[] copyArr;
    private static int testArraySize = 100_000;

    @BeforeAll
    public static void initiateArray() {

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

    @BeforeEach
    public void copyArr() {
        copyArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
    }

    @Test
    public void bubbleSortTest() {

        BubbleSort bubbleSort = new BubbleSort();

        long start = System.nanoTime();
        bubbleSort.sort(arr);
        long end = System.nanoTime();

        for (int i = 0; i < testArraySize; i++) {
            assertEquals(arr[i], i);
        }

        System.out.println("Bubble Sort : " + ((end - start) / 1_000_000) + "ms");
    }

    @Test
    public void selectionSortTest() {

        SelectionSort selectionSort = new SelectionSort();

        long start = System.nanoTime();
        selectionSort.sort(arr);
        long end = System.nanoTime();

        for (int i = 0; i < testArraySize; i++) {
            assertEquals(arr[i], i);
        }

        System.out.println("Selection Sort : " + ((end - start) / 1_000_000) + "ms");
    }

    @Test
    public void insertionSortTest() {

        InsertionSort insertionSort = new InsertionSort();

        long start = System.nanoTime();
        insertionSort.sort(arr);
        long end = System.nanoTime();

        for (int i = 0; i < testArraySize; i++) {
            assertEquals(arr[i], i);
        }

        System.out.println("Insertion Sort : " + ((end - start) / 1_000_000) + "ms");
    }

    @Test
    public void shellSortTest() {

        ShellSort shellSort = new ShellSort();

        long start = System.nanoTime();
        shellSort.sort(arr);
        long end = System.nanoTime();

        for (int i = 0; i < testArraySize; i++) {
            assertEquals(arr[i], i);
        }

        System.out.println("Shell Sort : " + ((end - start) / 1_000_000) + "ms");
    }

    @Test
    public void quickSortTest() {

        QuickSort quickSort = new QuickSort();

        long start = System.nanoTime();
        quickSort.sort(arr);
        long end = System.nanoTime();

        for (int i = 0; i < testArraySize; i++) {
            assertEquals(arr[i], i);
        }

        System.out.println("Quick Sort : " + ((end - start) / 1_000_000) + "ms");
    }
}
