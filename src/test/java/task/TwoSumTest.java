package task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Дан массив целых чисел nums и целое число target, вернуть индексы двух чисел так,
 * чтобы их сумма давала target.
 * Вы можете предположить, что каждый вход будет иметь ровно одно решение,
 * и вы не можете использовать один и тот же элемент дважды.
 * Вы можете возвращать ответ в любом порядке.
 */

public class TwoSumTest {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    void arrayOneTarget9Test() {
        assertThat(twoSum(new int[]{2, 7, 11, 15}, 9))
                .containsExactly(0, 1);
    }

    @Test
    void arrayTwoTarget6Test() {
        assertThat(twoSum(new int[]{3, 2, 4}, 6))
                .containsExactly(1, 2);
    }

    @Test
    void arrayThreeTarget6Test() {
        assertThat(twoSum(new int[]{3, 3}, 6))
                .containsExactly(0, 1);
    }

    @Test
    void arrayFourTarget8Test() {
        assertThat(twoSum(new int[]{1, 10, 3, 7}, 8))
                .containsExactly(0, 3);
    }
}
