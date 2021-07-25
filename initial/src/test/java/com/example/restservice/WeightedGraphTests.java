package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeTest;

@SpringBootTest
public class WeightedGraphTests {

	@Autowired
	private GreetingController controller;

	@Autowired
	private WeightedGraph weightedGraph;

	@BeforeTest(alwaysRun = true)
	public void setup() {
		weightedGraph.createDijGraph();
		Links links = new Links();
		links.attributes = new Attributes();
		links.source ="v1";
		links.target ="v4";
		links.attributes.weight =8;
		weightedGraph.setWeights(links);

		links.source ="v2";
		links.target ="v4";
		links.attributes.weight =5;
		weightedGraph.setWeights(links);

		links.source ="v1";
		links.target ="v2";
		links.attributes.weight =2;
		weightedGraph.setWeights(links);
	}
	@Test
	public void WeightPositiveTest_WeightedGraph() {
		setup();
		double res =weightedGraph.getWeightBetweenNodes("v1", "v4");
		Assert.state(weightedGraph.getWeightBetweenNodes("v1", "v4") == 7);
	}
	@Test
	public void WeightNegativeTest_WeightedGraph() {
		setup();
		double res =weightedGraph.getWeightBetweenNodes("v1", "v4");
		Assert.state(weightedGraph.getWeightBetweenNodes("v1", "v4") != 6);
	}
}
