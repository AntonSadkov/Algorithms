package algorithm;

public class Recursion {

    public static int findCount(int[] array, int index) {
        if (index < 0) {
            return 0;
        }
        return 1 + findCount(array, index - 1);
    }

    public static int searchMax(int[] array, int index, int max) {
        if (index == array.length) {
            return max;
        }
        if (array[index] > max) {
            max = array[index];
        }
        return searchMax(array, index + 1, max);
    }

    public static int searchMax(int[] array, int index) {
        if (index == 0) {
            return array[0];
        }
        int max = searchMax(array, index - 1);
        return (array[index] > max) ? array[index] : max;
    }

    public static int recursionSum(int[] array, int index) {
        if (index < 0) {
            return 0;
        }
        return array[index] + recursionSum(array, index - 1);
    }

    public static int getFactorial(int num) {
        if (num == 1 || num == 0) {
            return num;
        } else {
            return num * getFactorial(num - 1);
        }
    }

    public static void elementaryExampleRecursion(int num) {
        if (num == 0) {
            System.out.println();
        } else {
            System.out.print(num + " ");
            elementaryExampleRecursion(num - 1);
        }
    }
}
