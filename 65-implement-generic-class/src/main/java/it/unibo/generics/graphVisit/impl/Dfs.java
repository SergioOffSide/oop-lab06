package it.unibo.generics.graphVisit.impl;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Stack;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graphVisit.api.GraphVisitStrategy;

public class Dfs<N> implements GraphVisitStrategy<N> {

    /* spring: https://medium.com/@prajun_t/depth-first-search-dfs-21a4eab2908a */
    public Map<N, N> visitAlgorithm(final Graph<N> graph, final N source){
        final var stack = new Stack<N>();
        final var visited = new LinkedHashSet<N>();
        final var parents = new LinkedHashMap<N, N>();
        visited.add(source);
        stack.push(source);
        while (!stack.isEmpty()) {
            final var currentNode = stack.pop();
            for (final var neighbor : graph.linkedNodes(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    parents.put(neighbor, currentNode);
                }
            }
        }
        return parents;
    }

    @Override
    public String toString() {
        return "DFS algorithm";
    }
}
