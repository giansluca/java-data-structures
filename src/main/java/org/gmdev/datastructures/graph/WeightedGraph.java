package org.gmdev.datastructures.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * Undirected weighted graph implementation
 */
public class WeightedGraph {
	
	private class Node {
		private final String label;
		private final List<Edge> edges = new ArrayList<>();
		
		public Node(String label) {
			this.label = label;
		}
		
		public void addEdge(Node to, int weight) {
			edges.add(new Edge(this, to, weight));
		}
		
		public List<Edge> getEdges() {
			return edges;
		}

		@Override
		public String toString() {
			return label;
		}
	}
	
	private class Edge {
		private final Node from;
		private final Node to;
		private final int weight;
		
		public Edge(Node from, Node to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int getWeight() {
			return weight;
		}

		@Override
		public String toString() {
			return from + " --> " + to;
		}
	}
	
	private class NodeEntry {
		private final Node node;
		private final int priority;
		
		public NodeEntry(Node node, int priority) {
			this.node = node;
			this.priority = priority;
		}
	}
	
	private final Map<String, Node> nodes = new HashMap<>();
	
	public void addNode(String label) {
		nodes.putIfAbsent(label, new Node(label));
	}
	
	public boolean containsNode(String label) {
		return nodes.containsKey(label); 
	}
	
	public void addEdge(String from, String to, int weight) {
		var fromNode = nodes.get(from);
		if (fromNode == null)
			throw new IllegalArgumentException();
		
		var toNode = nodes.get(to);
		if (toNode == null)
			throw new IllegalArgumentException();
		
		fromNode.addEdge(toNode, weight);
		toNode.addEdge(fromNode, weight);
	}
	
	/**
	 * Shortest path algorithm (Dijkstra)
	 */
	public Path getShortestPath(String from, String to) {
		Node fromNode = nodes.get(from);
		if (fromNode == null)
			throw new IllegalArgumentException();
		
		Node toNode = nodes.get(to);
		if (toNode == null)
			throw new IllegalArgumentException();
		
		Map<Node, Integer> distances = new HashMap<>();
		for (var node : nodes.values())
			distances.put(node, Integer.MAX_VALUE);
		
		distances.replace(fromNode, 0);
		
		Map<Node, Node> previousNodes = new HashMap<>();
		
		Set<Node> visited = new HashSet<>();
			
		PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
				Comparator.comparingInt(ne -> ne.priority));
		
		queue.add(new NodeEntry(fromNode, 0));
		
		while (!queue.isEmpty()) {
			Node current = queue.remove().node;
			visited.add(current);
			
			for (var edge : current.getEdges()) {
				if (visited.contains(edge.to))
					continue;
				
				int newDistance = distances.get(current) + edge.weight;
				if (newDistance < distances.get(edge.to)) {
					distances.replace(edge.to, newDistance);
					previousNodes.put(edge.to, current);
					queue.add(new NodeEntry(edge.to, newDistance));
				}	
			}
		}
		
		return buildPath(previousNodes, toNode);
	}
	
	private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
		Stack<Node> stack = new Stack<>();
		stack.push(toNode);
		
		var previous = previousNodes.get(toNode);
		while (previous != null) {
			stack.push(previous);
			previous = previousNodes.get(previous);
		}
		
		var path = new Path();
		while (!stack.isEmpty()) {
			path.add(stack.pop().label);
		}
		
		return path;
	}
	
	public boolean hasCycle() {
		Set<Node> visited = new HashSet<>();
		for (var node : nodes.values()) {
			if (!visited.contains(node) && hasCycle(node, null, visited))
				return true;
		}
			
		return false;
	}
	
	private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
		visited.add(node);
		
		for (var edge : node.getEdges()) {
			if (edge.to == parent)
				continue;
			
			if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
				return true;
		}
		
		return false;
	}
	
	public void print() {
		for (var node : nodes.values()) {
			var edges = node.getEdges();
			
			if (!edges.isEmpty())
				edges.forEach(edge -> System.out.println("Node: " + node + " - Edge: " + edge + " weight: " + edge.getWeight()));
		}
	}
	
	/**
	 * Prim's algorithm - minimum spanning tree
	 */
	public WeightedGraph getMinimumSpanningTree() {
		var tree = new WeightedGraph();
		
		if (nodes.isEmpty())
			return tree;
		
		PriorityQueue<Edge> edges = new PriorityQueue<>(
			Comparator.comparingInt(edge -> edge.weight)
		);
		
		var startNode = nodes.values().iterator().next();
		edges.addAll(startNode.getEdges());
		tree.addNode(startNode.label);
		
		if (edges.isEmpty())
			return tree;
		
		while (tree.nodes.size() < nodes.size()) {
			var minEdge = edges.remove();
			var nextNode = minEdge.to;
			
			if (tree.containsNode(nextNode.label))
				continue;
			
			tree.addNode(nextNode.label);
			tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);
			
			for (var edge : nextNode.getEdges()) {
				if (!tree.containsNode(edge.to.label))
					edges.add(edge);
			}
		}
		
		return tree;
	}
	
	
}
