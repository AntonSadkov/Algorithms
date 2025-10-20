package task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Учитывая целочисленный массив nums, вернуть массив answer, который answer[i] равен произведению всех элементов,
 * за nums исключением nums[i].
 * Произведение любого префикса или суффикса nums гарантированно умещается в 32 - битное целое число.
 * Вам необходимо написать алгоритм, работающий O(n) вовремя и без использования операции деления.
 */

public class ProductOfArrayExceptSelfTest {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] answer = new int[nums.length];

        answer[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }

    @Test
    void case1() {
        assertThat(productExceptSelf(new int[]{1, 2, 3, 4}))
                .isEqualTo(new int[]{24, 12, 8, 6});
    }
}
