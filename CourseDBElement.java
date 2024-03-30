
public class CourseDBElement implements Comparable<CourseDBElement> {

	String courseId;

	int courseCrn;

	int credits;

	String roomNum;

	String instructor;

	public CourseDBElement() {
		this.courseId = null;
		this.courseCrn = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructor = null;
	}

	public CourseDBElement(String courseId, int courseCrn, int credits, String roomNum, String intructor) {
		this.courseId = courseId;
		this.courseCrn = courseCrn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = intructor;
	}

	@Override
	public int compareTo(CourseDBElement course) {
		return hashCode() - course.hashCode();
	}

	@Override
	public String toString() {
		return "\nCourse:" + courseId + " " + "CRN:" + courseCrn + " " + "Credits:" + credits
				+ " " + "Instructor:" + instructor + " " + "Room:" + roomNum;
	}
	@Override
	public int hashCode() {
		return Integer.toString(courseCrn).hashCode();
	}
	
	public int getCRN() {
		return courseCrn;
	}

	public String getID() {
		return courseId;
	}
	
	public String getRoomNum() {
		return roomNum;
	}

	public void setID(String courseId) {
		this.courseId = courseId;
	}

	public void setCRN(int courseCrn) {
		this.courseCrn = courseCrn;
	}

}
