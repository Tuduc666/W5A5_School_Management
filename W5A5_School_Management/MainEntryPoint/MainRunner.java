package W5A5_School_Management.MainEntryPoint;

import W5A5_School_Management.DAO.AttendingDAO;
import W5A5_School_Management.DAO.CourseDAO;
import W5A5_School_Management.DAO.StudentDAO;
import W5A5_School_Management.Models.Attending;
import W5A5_School_Management.Models.Course;
import W5A5_School_Management.Models.Student;

import java.util.List;
import java.util.Scanner;

/*
 * Please note:   I needed to change the following in MainRunner to match my program...
 *    - package name CoreJava changed to W5A5_School_Management (I want to label each week's work)
 *    - names of Course getters changed to getCourseID(), getCourseName(), getInstructorName()
 */


public class MainRunner {
    public static void main(String[] args) {
        System.out.println("Are you a(n)");
        System.out.println("1. Student");
        System.out.println("2. Quit");
        System.out.print("Answer: ");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        in.nextLine();
        if(answer == 1){
            StudentDAO studentDAO = new StudentDAO();
            List<Student> studentList = studentDAO.getStudents();
            System.out.print("Enter your email: ");
            String email = in.nextLine();
            System.out.print("Enter your password: ");
            String password = in.nextLine();

            if(studentDAO.validateUser(studentList, email, password)){
                CourseDAO courseDAO = new CourseDAO();
                AttendingDAO attendingDAO = new AttendingDAO();
                Student student = studentDAO.getStudentByEmail(studentList, email);
                List<Course> courseList = courseDAO.getAllCourses();
                List<Attending> attendingList = attendingDAO.getAttending();

                myClasses(student, courseList, attendingList);

                System.out.println("What would you like to do?");
                System.out.println("1. Register for a new Class");
                System.out.println("2. Log Out");
                System.out.print("Answer: ");
                answer = in.nextInt();
                in.nextLine();

                if(answer == 1){
                    //Display a list of all Classes
                    allClasses(courseList);
                    System.out.print("Select Course by ID Number: ");
                    int courseID = in.nextInt();
                    in.nextLine();
                    System.out.println("Attempting to Register...");
                    attendingDAO.registerStudentToCourse(attendingList, student.getEmail(), courseID);
                }

                System.out.println("Logging Out...");
            }
            else {
                System.out.println("Invalid Email or Password.");
            }
        }

        System.out.println("Closing Program. Goodbye.");
    }

    public static void myClasses(Student student, List<Course> courseList, List<Attending> attendingList){
        System.out.println("My Classes: ");
        System.out.printf("%-5s|%-25s|%-25s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");
        AttendingDAO attendingDAO = new AttendingDAO();
        List<Course> courses = attendingDAO.getStudentCourses(courseList, attendingList, student.getEmail());
        for(Course course : courses){
            System.out.printf("%-5s|%-25s|%-25s\n", course.getCourseID(), course.getCourseName(), course.getInstructorName());
        }
    }

    public static void allClasses(List<Course> courseList){
        System.out.println("My Classes: ");
        System.out.printf("%-5s|%-25s|%-25s\n", "#", "COURSE NAME", "INSTRUCTOR NAME");
        for(Course course : courseList){
            System.out.printf("%-5s|%-25s|%-25s\n", course.getCourseID(), course.getCourseName(), course.getInstructorName());
        }
    }
}
