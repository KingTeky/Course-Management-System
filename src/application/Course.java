package application;

import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private ArrayList<Student> enrolledStudents;
    private static int totalEnrolledStudents = 0;

    // Constructor to initialize the course details
    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter for the course code
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for the course name
    public String getName() {
        return name;
    }

    // Getter for the maximum capacity of the course
    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Method to enroll a student in the course
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            totalEnrolledStudents++;
            return true;
        }
        return false;
    }

    // Getter for the list of enrolled students
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Static method to get the total number of enrolled students across all courses
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}
