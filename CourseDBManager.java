import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	
	CourseDBStructure hashTable;
	
	public CourseDBManager() {
		hashTable = new CourseDBStructure(500);
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		hashTable.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return hashTable.get(crn);
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {

		if (!input.exists())
			throw new FileNotFoundException();

		Scanner scanner = new Scanner(input);

		ArrayList<String> rawData = new ArrayList<>();

		String courseId;

		int courseCrn;

		int credits;

		String roomNum;

		String instructor;

		// Adding full line of data to array

		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			if (!currentLine.isBlank() && !currentLine.isEmpty())
				rawData.add(currentLine);
		}

		// Parsing the strings from array and adding element to the structure

		for (String currentLine : rawData) {
			String[] substrings = currentLine.split(" ", 5);
			courseId = substrings[0];
			courseCrn = Integer.parseInt(substrings[1]);
			credits = Integer.parseInt(substrings[2]);
			roomNum = substrings[3];
			instructor = substrings[4];
			hashTable.add(new CourseDBElement(courseId, courseCrn, credits, roomNum, instructor));
		}

		scanner.close();
	}

	@Override
	public ArrayList<String> showAll() {
		return hashTable.showAll();
	}

}
