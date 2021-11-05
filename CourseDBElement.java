package application;

import java.util.Objects;

public class CourseDBElement {
	String courseID, roomNumber, instructorName;
	int CRN,cred;
	
	public CourseDBElement(String Id, int crn, int credits, String room, String teacher) {
		this.courseID = Id;
		this.CRN = crn;
		this.cred = credits;
		this.roomNumber = room;
		this.instructorName = teacher;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Integer.toString(CRN));
	}

	@Override
	public String toString() {
		return "Course:" + courseID + " CRN:" + CRN + " Credits:"
				+ cred + " Instructor:" + instructorName + " Room:" + roomNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDBElement other = (CourseDBElement) obj;
		return CRN == other.CRN;
	}

	public CourseDBElement() {
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getInstructorName() {
		return instructorName;
	}
	
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	public int getCred() {
		return cred;
	}
	
	public void setCred(int cred) {
		this.cred = cred;
	}
	
	public int getCRN() {
		return CRN;
	}
	
	public void setCRN(int parseInt) {
		this.CRN = parseInt;
	}

}
