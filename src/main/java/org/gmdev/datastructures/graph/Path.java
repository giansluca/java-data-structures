package org.gmdev.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Path class for the Dijkstra's algorithm
 */
public class Path {
	
	private final List<String> nodes = new ArrayList<>();
	
	public void add(String node) {
		nodes.add(node);
	}

	@Override
	public String toString() {
		return nodes.toString();
	}
	
	
}
