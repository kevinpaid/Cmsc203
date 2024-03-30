import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	int capacity;
	int size;
	double loadFactor = 1.5f;
	LinkedList<CourseDBElement>[] buckets;

	@SuppressWarnings("unchecked")
	public CourseDBStructure(int estimatedNumCourses) {
		int startNum = (int) Math.ceil(estimatedNumCourses / loadFactor);
		boolean isPrime = false;
		while (true) {

			if (isPrime && startNum % 4 == 3) {
				break;
			}
			startNum++;

			if (startNum <= 1) {
				continue;
			}
			if (startNum <= 3) {
				isPrime = true;
				continue;
			}
			if (startNum % 2 == 0 || startNum % 3 == 0) {
				continue;
			}
			for (int i = 5; i * i <= startNum; i += 6) {
				if (startNum % i == 0 || startNum % (i + 2) == 0) {
					break;
				}
			}
			isPrime = true;

		}
		capacity = startNum;
		buckets = new LinkedList[capacity];
	}

	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int number) {
		capacity = number;
		buckets = new LinkedList[capacity];
	}
	public CourseDBStructure() {
		this(500);
	}

	@Override
	public void add(CourseDBElement element) {

		int firstLocation = element.hashCode() % buckets.length;
		CourseDBElement currentCourse;

		if (buckets[firstLocation] == null) {
			buckets[firstLocation] = new LinkedList<>();
			buckets[firstLocation].add(element);
			return;
		}

		for (int index = 0; index < buckets[firstLocation].size(); index++) {
			currentCourse = buckets[firstLocation].get(index);
			if (currentCourse.compareTo(element) == 0) {
				buckets[firstLocation].set(index, element);
				return;
			}
		}
		buckets[firstLocation].add(element);

	}

	@Override
	public CourseDBElement get(int crn) throws IOException {

		CourseDBElement element = new CourseDBElement();
		element.setCRN(crn);

		for (LinkedList<CourseDBElement> list : buckets)
			if (list != null)
				for (CourseDBElement listElement : list)
					if (listElement.compareTo(element) == 0) {
						return listElement;
					}

		throw new IOException();
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> stringList = new ArrayList<>();

		for (LinkedList<CourseDBElement> bucket : buckets) {
			if (bucket != null) {
				for (CourseDBElement currentCourse : bucket) {
					stringList.add(currentCourse.toString());
				}
			}
		}

		return stringList;
	}

	@Override
	public int getTableSize() {
		return capacity;
	}

}
