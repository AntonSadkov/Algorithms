package task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Дан массив height, где каждая ячейка массива — это высота вертикальной линии на плоскости.
 * Нужно найти две линии, которые вместе с осью X образуют контейнер, способный вместить максимальное количество воды.
 * <p>
 * Изначально берём две крайние линии (самый широкий контейнер).
 * Считаем площадь.
 * Двигаем тот указатель, где высота меньше.
 * Повторяем, пока left < right.
 */
public class ContainerWthMostWaterTest {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Шаги поиска максимальной площади:
     * Начинаем с крайних линий: i=0, j=8.
     * Высоты: height[0] = 1, height[8] = 7.
     * min = 1, ширина = 8, площадь = 1 * 8 = 8.
     * Пока maxArea = 8.
     * -----------------------------
     * Двигаем левый указатель (так как 1 < 7), теперь i=1, j=8.
     * Высоты: height[1] = 8, height[8] = 7.
     * min = 7, ширина = 7, площадь = 7 * 7 = 49.
     * Теперь maxArea = 49.
     * -----------------------------
     * Двигаем правый указатель (так как 7 < 8), i=1, j=7.
     * Высоты: 8 и 3.
     * min = 3, ширина = 6, площадь = 3 * 6 = 18.
     * maxArea остаётся 49.
     * -----------------------------
     * Идём дальше аналогично. Все остальные комбинации дают меньше, чем 49.
     */
    @Test
    void case1() {
        assertThat(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}))
                .isEqualTo(49);
    }

    @Test
    void case2() {
        assertThat(maxArea(new int[]{1, 1}))
                .isEqualTo(1);
    }
}
