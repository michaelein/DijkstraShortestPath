package com.example.restservice;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class WeightedGraph {


    @Autowired
    public ParseJSON  parseJSON ;

    SimpleWeightedGraph<String, DefaultWeightedEdge> g;
    public WeightedGraph()
    {
       /* SimpleWeightedGraph<String, DefaultWeightedEdge> dg = createDiGraph();
        DijkstraShortestPath<String, DefaultWeightedEdge> dp = new DijkstraShortestPath<>(dg);
        dp.getPath("v1", "v4").getEdgeList().stream().forEach(System.out::println);

        int t=8;*/
    }
    @PostConstruct
    public void createDiGraph()
    {
      //  SimpleWeightedGraph<String, DefaultWeightedEdge> dg = createDiGraph();


        int t=8;
      //  ParseJSON parseJSON = .getBean("getUser");
        SomeClass someClass= parseJSON.GetSome();
        String h=someClass.links[0].source;
        g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);


        // iterating over an array
        for (int i = 0; i < someClass.links.length; i++) {

            if (!g.containsVertex(someClass.links[i].source)) {
                g.addVertex(someClass.links[i].source);

            }
            if (!g.containsVertex(someClass.links[i].target)) {
                g.addVertex(someClass.links[i].target);
            }
            if (!g.containsEdge(someClass.links[i].source,someClass.links[i].target))
            {
                DefaultWeightedEdge defaultWeightedEdge = g.addEdge(someClass.links[i].source,someClass.links[i].target);
                g.setEdgeWeight(defaultWeightedEdge, someClass.links[i].attributes.weight);
            }
            if (!g.containsEdge(someClass.links[i].target,someClass.links[i].source))
            {
                DefaultWeightedEdge defaultWeightedEdge = g.addEdge(someClass.links[i].target,someClass.links[i].source);
                g.setEdgeWeight(defaultWeightedEdge, someClass.links[i].attributes.weight);
            }
            // accessing each element of array



        }
      //  someClass.links.
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

        DijkstraShortestPath<String, DefaultWeightedEdge> dp = new DijkstraShortestPath<>(g);
        dp.getPath("v1", "v4").getEdgeList().stream().forEach(System.out::println);
      //  return g;
    }

}
