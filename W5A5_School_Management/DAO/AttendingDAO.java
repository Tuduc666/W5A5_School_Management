package W5A5_School_Management.DAO;

import W5A5_School_Management.Models.Attending;
import W5A5_School_Management.Models.Course;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendingDAO {
	// returns data list from attending file
    public List<Attending> getAttending(){
    	List<Attending> aList = new ArrayList<Attending>();
    	try {
    		String attendingPath = "C:\\Users\\Tam Uduc\\Documents\\tempJavaData\\attending.csv";
    		File attendingFile = new File(attendingPath);
    		Scanner sc = new Scanner(attendingFile);
    		
    		while (sc.hasNextLine()) {
    			String[] line = sc.nextLine().split(",");
        		aList.add(new Attending(line[0],line[1]));
    		}
    		
    	} catch (Exception e){
        		System.out.println("Something went wrong");
        	}
        	return aList;   
    }

    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseIDi){
    	boolean exist = false;
    	String courseID = courseIDi + "";    // converts integer to string
    	
    	for (Attending a : attending) 
    		if((a.getStudentEmail().equals(studentEmail)) && (a.getCourseID().equals(courseID))) exist = true;
    	
    	// write new attending record if not already exist
    	if(!exist) {
    		try {
    		String attendingPath = "C:\\Users\\Tam Uduc\\Documents\\tempJavaData\\attending.csv";
    		File attendingFile = new File(attendingPath);
    		FileWriter wr = new FileWriter(attendingFile, true);
    		wr.write(courseID + "," + studentEmail +"\r\n");
    		wr.close();   		
    		} catch (Exception e) {
    			System.out.println("Something went wrong while wrtting to attending file");
    		}
    	}	
    }

    // return a list of courses (with course detail) that the student is currently attending
    // note: courseList is passed in from Main, but not used here
    public List<Course> getStudentCourses(List<Course> notUsedCourse, List<Attending> attending, String studentEmail){
    	List<Course> cList = new ArrayList<Course>();
    	
    	// use student email to search attending table
    	for (Attending a : attending) {
    		if (a.getStudentEmail().equals(studentEmail)) {
    			CourseDAO allCourse = new CourseDAO();   // declare CourseDAO to use getAllCourses method
    			for (Course c : allCourse.getAllCourses()) {
    				if(a.getCourseID().equals(c.getCourseID())) cList.add(c);
    			}
    		}
    	}
    	
    	return cList;
    }

    public void saveAttending(List<Attending> attending){
    	String attendingPath = "C:\\Users\\Tam Uduc\\Documents\\tempJavaData\\attending.csv";

    		try {
    		File attendingFile = new File(attendingPath);
    		attendingFile.delete();             // delete and recreate to overwrite the file
    		attendingFile.createNewFile();
    		
    		FileWriter wr = new FileWriter(attendingFile, true);
        	for (Attending a : attending) 
    		wr.write(a.getCourseID() + "," + a.getStudentEmail());
    		wr.close();   		
    		} catch (Exception e) {
    			System.out.println("Something went wrong while wrtting to attending file");
    		}	
    }
}
