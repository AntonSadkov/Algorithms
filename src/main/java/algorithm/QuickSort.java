package algorithm;

public class QuickSort {

    /**
     * Здесь выполнен алгоритм быстрой сортировки.
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot); // Основные перестановки выполнены в методе partition.
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    /**
     *  Метод не совсем относиться к быстрой сортировке.
     *  Является комбинированным подходом из метода
     *  сортировки слиянием и быстрой сортировки.
     *  В этом случае, можно обойтись без merge,
     *  если не возвращать новый массив.
     */

    public static int[] quickSortArray(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int pivot = array[0];
        int countLess = 0;
        int countGreater = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < pivot) countLess++;
            else countGreater++;
        }

        int[] less = new int[countLess];
        int[] more = new int[countGreater];

        int indexLess = 0;
        int indexGreater = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < pivot) less[indexLess++] = array[i];
            else more[indexGreater++] = array[i];
        }

        int[] sortedLess = quickSortArray(less);
        int[] sortedGreater = quickSortArray(more);

        return merge(sortedLess, pivot, sortedGreater);
    }

    private static int[] merge(int[] less, int pivot, int[] more) {
        int[] sortedArray = new int[less.length + 1 + more.length];
        System.arraycopy(less, 0, sortedArray, 0, less.length);
        sortedArray[less.length] = pivot;
        System.arraycopy(more, 0, sortedArray, less.length + 1, more.length);
        return sortedArray;
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right --;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left ++;
                right --;
            }
        }
        return left;
    }
}
