package com.example.restservice;


import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.stereotype.Service;
import java.util.stream.IntStream;

import java.util.LinkedList;

@Service
public class GreetingService {

    public String getAge()
    {
            // note undirected edges are printed as: {<v1>,<v2>}
        //System.out.println(stringGraph.toString());
        return "11";
    }
}
