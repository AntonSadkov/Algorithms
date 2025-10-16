package task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Дан массив строк strs.
 * Необходимо сгруппировать все анаграммы вместе.
 * Анаграмма — это слово, составленное из тех же букв, что и другое слово, но в другом порядке.
 * Например: "eat", "tea", "ate" — это анаграммы.
 * Нужно вернуть список групп, где каждая группа — это список строк-анаграмм.
 */

public class GroupAnagramsTest {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    @Test
    void groupAnagramsCaseOne() {
        assertThat(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}))
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(List.of(
                        List.of("bat"),
                        List.of("nat", "tan"),
                        List.of("ate", "eat", "tea")));
    }
}
