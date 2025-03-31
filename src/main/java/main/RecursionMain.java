package main;

import algorithm.Recursion;

public class RecursionMain {

    public static void main(String[] args) {
        System.out.println(Recursion.getFactorial(4));
        Recursion.elementaryExampleRecursion(10);
        int[] array = {2, 10, 9, 7, 3, 1, 8, 5, 6, 4};
        System.out.println(Recursion.recursionSum(array, array.length - 1));
        System.out.println(Recursion.searchMax(array, 0, array[0]));
        System.out.println(Recursion.searchMax(array, array.length - 1));
        System.out.println(Recursion.findCount(array, array.length - 1));
    }
}
