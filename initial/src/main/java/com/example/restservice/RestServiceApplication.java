package com.example.restservice;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {


	private static SimpleWeightedGraph<String, DefaultWeightedEdge> createDiGraph()
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
		g.setEdgeWeight(e14, 1);
		DefaultWeightedEdge e12 = g.addEdge(v1, v2);
		g.setEdgeWeight(e12, 2);
		DefaultWeightedEdge e23 = g.addEdge(v2, v3);
		g.setEdgeWeight(e23, 2);
		DefaultWeightedEdge e34 = g.addEdge(v3, v4);
		g.setEdgeWeight(e34, 2);

		return g;
	}

	public static void main(String[] args) { 

		SpringApplication.run(RestServiceApplication.class, args);

	}

}

