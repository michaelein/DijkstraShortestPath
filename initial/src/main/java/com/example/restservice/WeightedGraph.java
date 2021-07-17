package com.example.restservice;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class WeightedGraph {

    public WeightedGraph()
    {
        SimpleWeightedGraph<String, DefaultWeightedEdge> dg = createDiGraph();
        DijkstraShortestPath<String, DefaultWeightedEdge> dp = new DijkstraShortestPath<>(dg);
        dp.getPath("v1", "v4").getEdgeList().stream().forEach(System.out::println);

        int t=8;
    }
    public  SimpleWeightedGraph<String, DefaultWeightedEdge> createDiGraph()
    {
        SimpleWeightedGraph<String, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        DefaultWeightedEdge e14 = g.addEdge(v1, v4);
        g.setEdgeWeight(e14, 10);
        DefaultWeightedEdge e12 = g.addEdge(v1, v2);
        g.setEdgeWeight(e12, 2);
        DefaultWeightedEdge e23 = g.addEdge(v2, v3);
        g.setEdgeWeight(e23, 2);
        DefaultWeightedEdge e34 = g.addEdge(v3, v4);
        g.setEdgeWeight(e34, 2);

        return g;
    }
   /* static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " + list.get(j).weight);
                }
            }
        }
    }

    public static void mymain() {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 3, 2);
        graph.addEgde(1, 2, 5);
        graph.addEgde(2, 3, 7);
        graph.addEgde(3, 4, 2);
        graph.addEgde(4, 0, 4);
        graph.addEgde(4, 1, 4);
        graph.addEgde(4, 5, 6);
        graph.printGraph();
    }*/
}
