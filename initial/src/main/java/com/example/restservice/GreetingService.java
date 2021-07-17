package com.example.restservice;


import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.stereotype.Service;
import java.util.stream.IntStream;


@Service
public class GreetingService {
    public void createGraphWithEulerianCircuit() {
        SimpleWeightedGraph<String, DefaultEdge> simpleGraph
                = new SimpleWeightedGraph<>(DefaultEdge.class);
        IntStream.range(1,5)
                .forEach(i-> simpleGraph.addVertex("v" + i));
        IntStream.range(1,5)
                .forEach(i-> {
                    int endVertexNo = (i + 1) > 5 ? 1 : i + 1;
                    simpleGraph.addEdge("v" + i,"v" + endVertexNo);
                });
    }
    public String getAge()
    {
        createGraphWithEulerianCircuit();

        // note undirected edges are printed as: {<v1>,<v2>}
        //System.out.println(stringGraph.toString());
        return "11";
    }
}
