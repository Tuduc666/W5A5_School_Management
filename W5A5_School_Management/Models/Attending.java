package W5A5_School_Management.Models;

public class Attending {
	String courseID;
	String studentEmail;
	
	public Attending() {
		super();
	}

	/**
	 * @param courseID
	 * @param studentEmail
	 */
	public Attending(String courseID, String studentEmail) {
		super();
		this.courseID = courseID;
		this.studentEmail = studentEmail;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	
   
}
