package W5A5_School_Management.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import W5A5_School_Management.Models.Course;

public class CourseDAO {
	// return every course in the table
    public List<Course> getAllCourses(){
    	List<Course> cList = new ArrayList<Course>();
    	try {
    		String coursesPath = "C:\\Users\\Tam Uduc\\Documents\\tempJavaData\\courses.csv";
    		File coursesFile = new File(coursesPath);
    		Scanner sc = new Scanner(coursesFile);

    		while (sc.hasNextLine()) {
    			String[] line = sc.nextLine().split(",");
        		cList.add(new Course(line[0],line[1],line[2]));
    		}
    		
    	} catch (Exception e){
        		System.out.println("Something went wrong");
        	}
        	return cList;   

    }
}
