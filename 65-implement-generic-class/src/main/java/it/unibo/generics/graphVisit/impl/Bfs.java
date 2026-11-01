package it.unibo.generics.graphVisit.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import it.unibo.generics.graphVisit.api.*;
import it.unibo.generics.graph.api.Graph;

public class Bfs<N> implements GraphVisitStrategy<N> {

    private void sourceInitializer(final N source, final Map<N, Color> colors) {
        colors.replace(source, Color.GRAY);
    }

    private void initilizeSingleSource(
        final Graph<N> graph,
        final Map<N, Color> colors,
        final Map<N, N> parents,
        final N source
    ) {
        for (final var node : graph.nodeSet()) {
            parents.put(node, null);
            colors.put(node, Color.WHITE);
        }
        sourceInitializer(source, colors);
    }

    private void processNeighbors(
        final Graph<N> graph,
        final Queue<N> queue,
        final Map<N, Color> colors,
        final Map<N, N> parents
    ) {
        final N currentNode = queue.poll();
            for (final var node : graph.linkedNodes(currentNode)) {
                if (colors.get(node) == Color.WHITE) {
                    colors.replace(node, Color.GRAY);
                    parents.replace(node, currentNode);
                    queue.add(node);
                }
            }
            colors.replace(currentNode, Color.BLACK);
    }

    /* spring: https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJI6p3LfesImYkdHXR5cTFQmq4GFiaxNiOtV4pJlWk9A&s=10 */
    public Map<N, N> visitAlgorithm(final Graph<N> graph, final N source) {
        final var parents = new LinkedHashMap<N, N>();
        final var colors = new LinkedHashMap<N, Color>();
        initilizeSingleSource(graph, colors, parents, source);
        final Queue<N> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            processNeighbors(graph, queue, colors, parents);
        }
        return parents;
    }

    @Override
    public String toString() {
        return "BFS algorithm";
    }
}
