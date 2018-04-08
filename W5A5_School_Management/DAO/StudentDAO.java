package W5A5_School_Management.DAO;

import W5A5_School_Management.Models.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
	// read student file, return data in a student list array
    public List<Student> getStudents(){
       	List<Student> sList = new ArrayList<Student>();
       	
    	try {
    	String studentsPath = "C:\\Users\\Tam Uduc\\Documents\\tempJavaData\\students.csv";
    	File studentsFile = new File(studentsPath);
    	Scanner sc = new Scanner(studentsFile);
 
    	while (sc.hasNextLine()) {
    		String[] line = sc.nextLine().split(",");            // read input line
    		sList.add(new Student(line[0], line[1], line[2]));   // create new student, add to arraylist	
    	}
    	}
    	catch (Exception e){
    		System.out.println("Something went wrong");
    	}
    	return sList;      
    }

    // use email to search for student in student list
    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
    //	Student rStudent = new Student();    // initialize to null.  Will return null if not found
    	Student rStudent = new Student(" "," "," ");    // initialize to blank, null would crash
    	for (Student s : studentList) {
    	    if (s.getEmail().equals(studentEmail)) return s;
    	}
    	return rStudent;   // return if not found
    }

    // validate student password
    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
    	Student s = getStudentByEmail(studentList, studentEmail);
    	if (s.getPass().equals(studentPass)) return true;
    	else return false;
    }
}
