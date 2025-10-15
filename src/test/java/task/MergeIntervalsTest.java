package task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Учитывая массив, intervals где, объединить все перекрывающиеся интервалы и вернуть массив
 * неперекрывающихся интервалов, которые покрывают все интервалы во входных данных
 * intervals[i] = [start i, end i].
 */

public class MergeIntervalsTest {

    @Test
    void intervalCaseOne() {
        assertThat(new int[][]{{}})
                .isDeepEqualTo(new int[][]{{}});
    }
}
