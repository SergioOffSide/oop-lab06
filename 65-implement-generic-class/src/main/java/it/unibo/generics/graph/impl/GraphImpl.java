package it.unibo.generics.graph.impl;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graphVisit.api.*;

public class GraphImpl<N> implements Graph<N> {
    
    private final Map<N, Set<N>> graph = new LinkedHashMap<>();
    private final GraphVisitStrategy<N> visitStrategy;

    public GraphImpl(final GraphVisitStrategy<N> strategy) {
        this.visitStrategy = strategy;
    }

    public void addNode(final N node) {
        if (node != null) {
            graph.putIfAbsent(node, new LinkedHashSet<>());
        }
    }

    private boolean containsNodesInGraph(final N N1, final N N2) {
        return graph.containsKey(N1) && graph.containsKey(N2);
    }

    public void addEdge(final N source, final N target) {
        if (source != null && target != null && containsNodesInGraph(source, target)) {
            graph.get(source).add(target);
        }
    }

    public Set<N> nodeSet() {
        return graph.keySet();
    }

    public Set<N> linkedNodes(final N node) {
        return Set.copyOf(graph.get(node));
    }

    private List<N> pathSearcher(final N source, final N target, final Map<N, N> parents, final List<N> path) {
        if (source == target) {
            path.addFirst(source);
            return path;
        } else if (parents.get(target) == null) {
            return new LinkedList<>();
        }
        path.addFirst(target);
        return pathSearcher(source, parents.get(target), parents, path);
    }

    public List<N> getPath(final N source, final N target) {
        final var parents = visitStrategy.visitAlgorithm(this, source);
        final var path = new LinkedList<N>();
        return pathSearcher(source, target, parents, path);
    }

}
