package task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Учитывая массив, intervals где, объединить все перекрывающиеся интервалы и вернуть массив
 * неперекрывающихся интервалов, которые покрывают все интервалы во входных данных
 * intervals[i] = [start i, end i].
 */

public class MergeIntervalsTest {

    int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);
        return merged.toArray(new int[merged.size()][]);
    }

    @Test
    void intervalCaseOne() {
        assertThat(merge(new int[][]{{4, 7}, {1, 4}}))
                .isDeepEqualTo(new int[][]{{1, 7}});
    }

    @Test
    void intervalCaseTwo() {
        assertThat(merge(new int[][]{{1, 2}, {3, 4}, {5, 6}}))
                .isDeepEqualTo(new int[][]{{1, 2}, {3, 4}, {5, 6}});
    }

    @Test
    void intervalCaseTree() {
        assertThat(merge(new int[][]{{4, 7}, {1, 4}}))
                .isDeepEqualTo(new int[][]{{1, 7}});
    }

    @Test
    void intervalCaseFour() {
        assertThat(merge(new int[][]{{1, 10}, {2, 3}, {4, 5}}))
                .isDeepEqualTo(new int[][]{{1, 10}});
    }

    @Test
    void intervalCaseFive() {
        assertThat(merge(new int[][]{}))
                .isDeepEqualTo(new int[][]{});
    }
}
