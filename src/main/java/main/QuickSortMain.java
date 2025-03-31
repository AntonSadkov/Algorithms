package main;

import algorithm.QuickSort;

import java.util.Arrays;

public class QuickSortMain {

    public static void main(String[] args) {
        int[] array = {2, 10, 9, 7, 3, 1, 8, 5, 6, 4};
        System.out.println(Arrays.toString(QuickSort.quickSortArray(array)));

        QuickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
