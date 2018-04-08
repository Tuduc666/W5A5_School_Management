package W5A5_School_Management.Models;

public class Course {
	private String courseID;
	private String courseName;
	private String instructorName;
    
    public Course() {
    	this.courseID = null;
    	this.courseName = null;
    	this.instructorName = null;
    }
    
    public Course(String courseID, String courseName, String instructorName) {
    	this.courseID = courseID;
    	this.courseName = courseName;
    	this.instructorName = instructorName;
    }

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

}
