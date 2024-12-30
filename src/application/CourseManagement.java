package application;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Student, HashMap<Course, Double>> studentGrades = new HashMap<>();

    // Getter for courses list
    public static ArrayList<Course> getCourses() {
        return courses;
    }

    // Getter for student grades
    public static HashMap<Student, HashMap<Course, Double>> getStudentGrades() {
        return studentGrades;
    }

    // Method to add a new course
    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course course = new Course(courseCode, name, maxCapacity);
        courses.add(course);
    }

    // Method to enroll a student in a course
    public static boolean enrollStudent(Student student, Course course) {
        if (course.enrollStudent(student)) {
            student.enrollInCourse(course);
            studentGrades.putIfAbsent(student, new HashMap<>());
            return true;
        }
        return false;
    }

    // Method to assign a grade to a student for a specific course
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
        studentGrades.get(student).put(course, grade);
    }

    // Method to calculate the overall grade for a student
    public static double calculateOverallGrade(Student student) {
        HashMap<Course, Double> grades = studentGrades.get(student);
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return grades.size() > 0 ? total / grades.size() : 0;
    }
}
