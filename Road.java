
public class Road implements Comparable <Road> {
	
	private Town srcTown;
	private Town dstTown;
	private int weight;
	private String name;
	
	public Road(Town srcTown, Town dstTown, int distance, String name) {
		this.srcTown = srcTown;
		this.dstTown = dstTown;
		this.weight = distance;
		this.name = name;
	}
	
	public Road(Town srcTown, Town dstTown, int distance) {
		this(srcTown, dstTown, distance, null);
	}
	
	public Road(Town srcTown, Town dstTown) {
		this(srcTown, dstTown, 0);
	}
	
	public Road(Town srcTown, int distance) {
		this (srcTown, null, distance, null);
	}
	
	public Town getSource() {
		return this.srcTown;
	}
	
	public String getSrcTownName() {
		return getSource().getName();
	}
	
	public Town getDestination() {
		return this.dstTown;
	}
	
	public String getDstTownName() {
		return getDestination().getName();
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Road o) {
		return getWeight() - o.getWeight();
	}
	
	@Override
	public boolean equals(Object roadObj) {
		if(!(roadObj instanceof Road))
			return false;
		Road roadCompared = (Road) roadObj;
		
		return ((getDstTownName().equals(roadCompared.getDstTownName()))
				&& (getSrcTownName().equals(roadCompared.getSrcTownName())))
				|| ((getDstTownName().equals(roadCompared.getSrcTownName()))
				&& getSrcTownName().equals(roadCompared.getDstTownName()));
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}

}
