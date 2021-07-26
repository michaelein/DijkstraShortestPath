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
    SimpleWeightedGraph<String, DefaultWeightedEdge> DijkstraGrapg;
    DijkstraShortestPath<String, DefaultWeightedEdge> dp;
    Links links;

    boolean setWeights(Links links)
    {
        try {
                if (!DijkstraGrapg.containsVertex(links.source)) {
                    DijkstraGrapg.addVertex(links.source);
                }
                if (!DijkstraGrapg.containsVertex(links.target)) {
                    DijkstraGrapg.addVertex(links.target);
                }
                if (links.source != links.target) {
                    DefaultWeightedEdge defaultWeightedEdge = DijkstraGrapg.addEdge(links.source, links.target);
                    DijkstraGrapg.setEdgeWeight(defaultWeightedEdge, links.attributes.weight);//every weight is ok
                }
                else {
                    System.out.println("source must be diff from target");
                    return false;
                }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @PostConstruct
    public void createDijGraph()
    {
        SomeClass DijkstraClass= parseJSON.GetSome();
        DijkstraGrapg = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        for (int i = 0; i < DijkstraClass.links.length; i++) {
            setWeights(DijkstraClass.links[i]);
        }

        //--forTest
        dp = new DijkstraShortestPath<>(DijkstraGrapg);
        dp.getPath("d1263a41-5e00-4d6b-9611-0af0cdf371ce", "f85456a2-4869-4678-b0eb-d855db8c2a1c").getEdgeList().stream().forEach(System.out::println);
        System.out.println( dp.getPath("d1263a41-5e00-4d6b-9611-0af0cdf371ce", "f85456a2-4869-4678-b0eb-d855db8c2a1c").getWeight());
        links = new Links();
        links.attributes = new Attributes();
    }
    public double getWeightBetweenNodes(String s, String d)
    {
        if (!DijkstraGrapg.containsVertex(s) || !DijkstraGrapg.containsVertex(d))
        {
            return 0;
        }
        return dp.getPath(s, d).getWeight();
    }
    public String getShortBetweenNodes(String s, String d)
    {
        if (!DijkstraGrapg.containsVertex(s) || !DijkstraGrapg.containsVertex(d))
        {
            return "Unable to find one vertex";
        }
       return dp.getPath(s, d).getEdgeList().toString();
    }
    public boolean UpdateWeight(String s, String d ,double wight )
    {
        links.source =s;
        links.target =d;
        links.attributes.weight =wight;
        if (!DijkstraGrapg.containsVertex(s) || !DijkstraGrapg.containsVertex(d))
        {
            System.out.println("The vertices are equal");
            return false;
        }
        return setWeights(links);
    }
}
