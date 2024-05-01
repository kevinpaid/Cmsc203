import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TownGraphManager implements TownGraphManagerInterface {
	
	private Graph graph;
	
	public TownGraphManager() {
		graph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		if (graph.addEdge(new Town (town1), new Town (town2), weight, roadName) != null)
			return true;
		else
			return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(new Town (town1), new Town (town2)).getName();
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town (v));
	}

	@Override
	public Town getTown(String name) {
		return graph.getVertex(new Town (name));
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town (v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town (town1), new Town (town2));
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> allRoads = new ArrayList<>();
		Iterator<Road> iterator = graph.edgeSet().iterator();
		
		while (iterator.hasNext())
			allRoads.add(iterator.next().getName());
		
		Collections.sort(allRoads);
		
		return allRoads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		if (graph.removeEdge(new Town (town1), new Town (town2), 0, road) != null)
			return true;
		else 
			return false;
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town (v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<>();
		Iterator<Town> iterator = graph.vertexSet().iterator();
		
		while (iterator.hasNext())
			allTowns.add(iterator.next().getName());
		
		allTowns.sort(String.CASE_INSENSITIVE_ORDER);
		
		return allTowns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town (town1), new Town (town2));
	}

}
