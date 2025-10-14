package main;

import algorithm.BinarySearch;
import algorithm.Sort;

import java.util.Arrays;

public class BinarySearchMain {
    private static final Sort sortArray = new Sort();
    private static final BinarySearch search = new BinarySearch();

    public static void main(String[] args) {
        int[] array = {2, 10, 9, 7, 3, 1, 8, 5, 6, 4};
        System.out.println(Arrays.toString(sortArray.sortDesc(array)));
        search.outputSearch(array, 1);
    }
}