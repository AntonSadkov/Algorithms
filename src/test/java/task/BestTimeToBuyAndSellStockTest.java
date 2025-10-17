package task;

import org.junit.jupiter.api.Test;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Есть массив prices[i], где i — это день, а prices[i] — цена акции в этот день.
 * Нужно купить в один день и продать в другой день позже, чтобы получить максимальную прибыль.
 * Если прибыли получить невозможно (цены только падают), результат должен быть 0.
 * <p>
 * Пример:
 * prices = [7,1,5,3,6,4]
 * Купить в день 2 по цене 1;
 * Продать в день 5 по цене 6;
 * Прибыль = 6 - 1 = 5;
 */

public class BestTimeToBuyAndSellStockTest {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = max(maxProfit, prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    @Test
    void case1() {
        assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4}))
                .isEqualTo(5);
    }
}
