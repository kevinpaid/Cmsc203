

public class Town implements Comparable<Town> {

	private String name;

	public Town(String name) {
		this.name = name;
	}

	public Town(Town templateTown) {
		this.name = templateTown.getName();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Town o) {
		return getName().compareTo(o.getName());
	}

	@Override
	public boolean equals(Object townObj) {
		if (!(townObj instanceof Town))
			return false;

		Town townCompared = (Town) townObj;

		return getName().equals(townCompared.getName());
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

}
