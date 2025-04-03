package main;

import algorithm.BreadthFirstSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearchMain {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>(Map.of(
                "Toyota", Arrays.asList("Lexus", "Acura"),
                "Acura", Arrays.asList("Nissan", "Infinity"),
                "Infinity", Arrays.asList("BMW", "Alpine"),
                "Alpine", Arrays.asList("Mercedes", "Porsche"),
                "Porsche", Arrays.asList("Volkswagen", "Audi")
        ));

        BreadthFirstSearch.search(graph, "Toyota", "Porsche");
        BreadthFirstSearch.search(graph, "Toyota", "Lada");
    }
}
