package it.unibo.generics.graphVisit.api;

import java.util.Map;

import it.unibo.generics.graph.api.Graph;

public interface GraphVisitStrategy<N> {

    /**
     * Visit algorithm to implement
     * @param graph
     *             the graph to use
     * @param source
     *              the start node
     * @return parents map to track easily all pathes
     */
    Map<N, N> visitAlgorithm(Graph<N> graph, N source);
}
