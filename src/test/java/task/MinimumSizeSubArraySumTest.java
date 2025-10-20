package task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Дан массив положительных целых чисел nums и положительное целое число target.
 * Верните минимальную длину подмассива сумма которых больше или равна target.
 * Если такого подмассива нет, верните 0.
 */

public class MinimumSizeSubArraySumTest {

    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    @Test
    void case1() {
        assertThat(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}))
                .isEqualTo(2);
    }
}
