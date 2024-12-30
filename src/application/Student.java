package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private String id;
    private ArrayList<Course> enrolledCourses;
    private HashMap<Course, Double> grades;

    // Constructor to initialize the student's details and enrolled courses
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    // Getter for the student's name
    public String getName() {
        return name;
    }

    // Setter for the student's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the student's ID
    public String getId() {
        return id;
    }

    // Setter for the student's ID
    public void setId(String id) {
        this.id = id;
    }

    // Method to enroll a student in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Method to assign a grade to a student for a specific course
    public void assignGrade(Course course, double grade) {
        grades.put(course, grade);
    }

    // Method to get the grade for a specific course
    public Double getGrade(Course course) {
        return grades.get(course);
    }

    // Method to get the list of enrolled courses
    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
}
