import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
	
	private Map<Town, Set<Road>> adjacencyList;
	
	public Graph() {
		adjacencyList = new HashMap<Town, Set<Road>>();
	}

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		for(Road road : this.edgesOf(sourceVertex)) {
			if(road.equals(new Road(sourceVertex, destinationVertex, 0, null)))
				return road;
		}
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road srcToAdd = new Road(sourceVertex, destinationVertex, weight, description);
		Road dstToAdd = new Road(destinationVertex, sourceVertex, weight, description);
		
		adjacencyList.putIfAbsent(sourceVertex, new HashSet<>());
		adjacencyList.get(sourceVertex).add(srcToAdd);
		
		adjacencyList.putIfAbsent(destinationVertex, new HashSet<>());
		adjacencyList.get(destinationVertex).add(dstToAdd);
		
		
		return srcToAdd;
	}
	
	public Town getVertex(Town vertex) {
		for (Town town : adjacencyList.keySet())
			if (town.equals(vertex))
				return town;
		
		return null;
	}

	@Override
	public boolean addVertex(Town v) {
		return adjacencyList.putIfAbsent(v, new HashSet<>()) == null ? true : false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
			return adjacencyList.get(sourceVertex).contains(getEdge(sourceVertex, destinationVertex));
	}

	@Override
	public boolean containsVertex(Town v) {
		return adjacencyList.containsKey(v);
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> mySet = new HashSet<>();
		
		for(Set<Road> edgesSet : adjacencyList.values())
			for(Road currentRoad : edgesSet)
				mySet.add(currentRoad);
		
		return mySet;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		return adjacencyList.get(vertex);
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		if (sourceVertex == null || destinationVertex == null || sourceVertex.compareTo(destinationVertex) == 0)
			return null;
		Road firstToRemove = new Road (sourceVertex, destinationVertex, weight, description);
		Road secondToRemove = new Road (destinationVertex, sourceVertex, weight, description);
		
		adjacencyList.get(sourceVertex).remove(firstToRemove);
		adjacencyList.get(destinationVertex).remove(secondToRemove);
		return firstToRemove;
	}

	@Override
	public boolean removeVertex(Town v) {
		return adjacencyList.remove(v, adjacencyList.get(v));
	}

	@Override
	public Set<Town> vertexSet() {
		return adjacencyList.keySet();
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		Map<Town, Integer> distances = new HashMap<>();
		Map<Town, Town> previous = new HashMap<>();
		PriorityQueue<Town> queue = new PriorityQueue<>((a, b) -> distances.get(a) - distances.get(b));
		
		for (Town town :this.vertexSet())
			distances.put(town, Integer.MAX_VALUE);
		
		distances.put(sourceVertex, 0);
		queue.offer(sourceVertex);
		
		while (!queue.isEmpty()) {
			
			Town currentTown = queue.poll();
			
			for (Town neighbor : getNeighbors(currentTown)) {
				
				int newDistance = distances.get(currentTown) + getEdge(currentTown, neighbor).getWeight();
				
				if (newDistance < distances.get(neighbor)) {
					distances.put(neighbor, newDistance);
					previous.put(neighbor, currentTown);
					queue.remove(neighbor);
					queue.add(neighbor);
				}
			}
		}
		// Returning path solution
		ArrayList<String> path = new ArrayList<>();
		Town current = destinationVertex;
		
		while (previous.containsKey(current)) {
			Town nextTown = previous.get(current);
			Road road = getEdge(current, nextTown);
			path.add(nextTown.getName() + " via " + road.getName() + " to " + current.getName() + " " + road.getWeight() + " mi");
			current = nextTown;
		}
		
		Collections.reverse(path);
		
		return path;
	}

	@SuppressWarnings("unused")
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		int nothing = 0;
	}
	// Method for returning adjacent towns from given town
	public Set<Town> getNeighbors(Town town){
		Set<Town> solution = new HashSet<>();
		
		for (Road road : this.edgesOf(town))
			solution.add(road.getDestination());
		
		return solution;
	}

}
