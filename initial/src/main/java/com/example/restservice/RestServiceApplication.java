package com.example.restservice;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.IntStream;

@SpringBootApplication
public class RestServiceApplication {

	/*public static void createGraphWithEulerianCircuit() {
		SimpleWeightedGraph<String, DefaultEdge> simpleGraph
				= new SimpleWeightedGraph<>(DefaultEdge.class);
		IntStream.range(1,5)
				.forEach(i-> simpleGraph.addVertex("v" + i));
		IntStream.range(1,5)
				.forEach(i-> {
					int endVertexNo = (i + 1) > 5 ? 1 : i + 1;
					simpleGraph.addEdge("v" + i,"v" + endVertexNo);
				});
	}*/
	/**
	 * Creates a toy directed graph based on URL objects that represents link structure.
	 *
	 * @return a graph based on URL objects.
	 */
	private static Graph<URL, DefaultEdge> createHrefGraph()
	{
		Graph<URL, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

		try {
			URL amazon = new URL("http://www.amazon.com");
			URL yahoo = new URL("http://www.yahoo.com");
			URL ebay = new URL("http://www.ebay.com");

			// add the vertices
			g.addVertex(amazon);
			g.addVertex(yahoo);
			g.addVertex(ebay);

			// add edges to create linking structure
			g.addEdge(yahoo, amazon);
			g.addEdge(yahoo, ebay);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return g;
	}

	/**
	 * Create a toy graph based on String objects.
	 *
	 * @return a graph based on String objects.
	 */
	private static Graph<String, DefaultEdge> createStringGraph()
	{
		Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

		String v1 = "v1";
		String v2 = "v2";
		String v3 = "v3";
		String v4 = "v4";

		// add the vertices
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);

		// add edges to create a circuit
		g.addEdge(v1, v2);
		g.addEdge(v2, v3);
		g.addEdge(v3, v4);
		g.addEdge(v4, v1);

		return g;
	}

	private static DefaultDirectedGraph<String, DefaultEdge> createDiGraph()
	{
		DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

		String v1 = "v1";
		String v2 = "v2";
		String v3 = "v3";
		String v4 = "v4";

		// add the vertices
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);

		// add edges to create a circuit
		g.addEdge(v1, v2);
		g.addEdge(v2, v3);
		g.addEdge(v3, v4);
		g.addEdge(v4, v1);
		g.addEdge(v2, v4);


		return g;
	}
	public static void main(String[] args) {
	//	Greeting d=new Greeting(1,"michael");
	//	int f= (int) d.getId();
		Graph<String, DefaultEdge> stringGraph = createStringGraph();

		// note undirected edges are printed as: {<v1>,<v2>}
		System.out.println(stringGraph.toString());

		// create a graph based on URL objects
		Graph<URL, DefaultEdge> hrefGraph = createHrefGraph();

		// note directed edges are printed as: (<v1>,<v2>)
		System.out.println(hrefGraph.toString());

		DefaultDirectedGraph<String, DefaultEdge> dg = createDiGraph();
		DijkstraShortestPath<String, DefaultEdge> dp = new DijkstraShortestPath<>(dg);
		dp.getPath("v1", "v4").getEdgeList().stream().forEach(System.out::println);
		int t=8;
		SpringApplication.run(RestServiceApplication.class, args);

	}

}

