package org.gmdev.datastructures.graph;

/**
 * Graph
 */
public class GraphDriver {
	
	public static void driver() {
		var graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addEdge("A", "B");
		graph.addEdge("B", "D");
		graph.addEdge("D", "C");
		graph.addEdge("A", "C");
		
		graph.print();
		graph.traverseDepthFirstRec("A");
		System.out.println("**********");
		graph.traverseDepthFirstIte("C");
		System.out.println("**********");
		graph.traverseBreadthFirst("A");
		System.out.println("**********");
		graph.traverseBreadthFirst("C");
		System.out.println("**********");
		
		var graph2 = new Graph();
		graph2.addNode("X");
		graph2.addNode("A");
		graph2.addNode("B");
		graph2.addNode("P");
		graph2.addEdge("X", "A");
		graph2.addEdge("X", "B");
		graph2.addEdge("A", "P");
		graph2.addEdge("B", "P");
		
		var list = graph2.topologicalSort();
		System.out.println(list);
		System.out.println("**********");
		
		var graph3 = new Graph(); 
		graph3.addNode("A");
		graph3.addNode("B");
		graph3.addNode("C");
		graph3.addEdge("A", "B");
		graph3.addEdge("B", "C");
		graph3.addEdge("C", "A");
		System.out.println(graph3.hasCycle());
		System.out.println("**********");
		System.out.println("**********");
		
		// Weighted graph
		var wGraph = new WeightedGraph();
		wGraph.addNode("A");
		wGraph.addNode("B");
		wGraph.addNode("C");
		wGraph.addEdge("A", "B", 1);
		wGraph.addEdge("B", "C", 2);
		wGraph.addEdge("A", "C", 10);
		wGraph.print();
		
		var path = wGraph.getShortestPath("A", "C");
		System.out.println(path);
		System.out.println("Has cycle: " + wGraph.hasCycle());
		System.out.println("**********");
		System.out.println("**********");
		
		// minimum spanning tree
		var wGraph2 = new WeightedGraph();
		wGraph2.addNode("A");
		wGraph2.addNode("B");
		wGraph2.addNode("C");
		wGraph2.addNode("D");
		wGraph2.addEdge("A", "B", 3);
		wGraph2.addEdge("B", "D", 4);
		wGraph2.addEdge("C", "D", 5);
		wGraph2.addEdge("A", "C", 1);
		wGraph2.addEdge("B", "C", 2);
		
		var tree = wGraph2.getMinimumSpanningTree();
		tree.print();
	}

}

