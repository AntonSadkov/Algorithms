package algorithm;

public class BinarySearch {
    private final Sort sort = new Sort();

    public void outputSearch(int[] array, int target) {
        int result = binarySearch(array, target);
        if (result != -1) {
            System.out.println("Элемент найден: " + array[result]);
        } else {
            System.out.println("Элемент не найден");
        }
    }

    private int binarySearch(int[] array, int target) {
        int[] sortArray = sort.sortDesc(array);
        int left = 0;
        int right = sortArray.length - 1;
        int count = 0;

        while(left <= right) {
            count ++;
            int mid = left + (right - left) / 2;

            if (sortArray[mid] == target) {
                System.out.println("Количество шагов: " + count);
                return mid;
            }

            if (sortArray[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Количество шагов: " + count);
        return -1;
    }
}
