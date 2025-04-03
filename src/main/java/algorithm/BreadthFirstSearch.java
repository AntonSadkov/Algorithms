package algorithm;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    public static void search(Map<String, List<String>> graph, String firstValue, String target) {
        if (breadthFirstSearch(graph, firstValue, target)) {
            System.out.println("Найдено: " + target);
        } else {
            System.out.println("Не найден: " + target);
        }
    }

    private static boolean breadthFirstSearch(Map<String, List<String>> graph, String firstValue, String target) {
        Queue<String> queue = new LinkedList<>(List.of(firstValue));
        Set<String> reviewed = new HashSet<>(Set.of(firstValue));

        while(!queue.isEmpty()) {
            String value = queue.poll();
            System.out.println("Смотрю: " + value);
            if (value.equals(target)) {
                return true;
            }
            for (String review : graph.getOrDefault(value, Collections.emptyList())) {
                if (!reviewed.contains(review)) {
                    queue.add(review);
                    reviewed.add(review);
                }
            }
        }
        return false;
    }
}
