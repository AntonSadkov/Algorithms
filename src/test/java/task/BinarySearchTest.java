package task;

import algorithm.Sort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Дан массив целых чисел num, отсортированный по возрастанию, и целое число target.
 * Напишите функцию для поиска target в num. Если target существует, вернуть его индекс.
 * В противном случае вернуть -1.
 * Вам необходимо написать алгоритм, имеющий O(log n)сложность во время выполнения.
 * Пример 1:
 * Ввод: num = [-1,0,3,5,9,12], цель = 9
 * Вывод: 4
 * Объяснение: 9 присутствует в num, и его индекс равен 4
 * Пример 2:
 * Ввод: num = [-1,0,3,5,9,12], цель = 2
 * Вывод: -1
 * Объяснение: число 2 отсутствует в num, поэтому возвращаем -1
 * Ограничения:
 * 1 <= num.length <= 104
 * -104 < num[i], target < 104
 * Все целые числа num в уникальны,
 * num сортируется в порядке возрастания.
 */

public class BinarySearchTest {
    private static final Sort sort = new Sort();
    private final int[] array = {-1, 0, 3, 5, 9, 12};

    public static int search(int[] num, int target) {
        int[] sortArray = sort.sortAsc(num);
        int left = 0;
        int right = sortArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortArray[mid] == target) {
                return mid;
            } else if (sortArray[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    void output4Test() {
        assertThat(search(array, 9)).isEqualTo(4);
    }

    @Test
    void outputMinus1Test() {
        assertThat(search(array, 2)).isEqualTo(-1);
    }
}
