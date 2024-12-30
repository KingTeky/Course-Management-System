package application;

import java.util.Scanner;

public class AdminInterface {
    private static Scanner scanner = new Scanner(System.in);

    // Main method to display the menu and interact with the administrator
    public static void main(String[] args) {
        while (true) {
            System.out.println("Administrator Menu:");
            System.out.println("1. Add New Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate Overall Grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateOverallGrade();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add a new course
    private static void addNewCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        CourseManagement.addCourse(courseCode, name, maxCapacity);
        System.out.println("Course added successfully!");
    }

    // Method to enroll a student in a course
    private static void enrollStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = new Student(studentName, studentId);
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = null;
        for (Course c : CourseManagement.getCourses()) {
            if (c.getCourseCode().equals(courseCode)) {
                course = c;
                break;
            }
        }
        if (course != null) {
            if (CourseManagement.enrollStudent(student, course)) {
                System.out.println("Student enrolled successfully!");
            } else {
                System.out.println("Failed to enroll student. Course might be full.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to assign a grade to a student for a course
    private static void assignGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = null;
        for (Student s : CourseManagement.getStudentGrades().keySet()) {
            if (s.getId().equals(studentId)) {
                student = s;
                break;
            }
        }
        if (student != null) {
            System.out.print("Enter course code: ");
            String courseCode = scanner.nextLine();
            Course course = null;
            for (Course c : CourseManagement.getCourses()) {
                if (c.getCourseCode().equals(courseCode)) {
                    course = c;
                    break;
                }
            }
            if (course != null) {
                System.out.print("Enter grade: ");
                double grade = Double.parseDouble(scanner.nextLine());
                CourseManagement.assignGrade(student, course, grade);
                System.out.println("Grade assigned successfully!");
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to calculate the overall grade for a student
    private static void calculateOverallGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = null;
        for (Student s : CourseManagement.getStudentGrades().keySet()) {
            if (s.getId().equals(studentId)) {
                student = s;
                break;
            }
        }
        if (student != null) {
            double overallGrade = CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall Grade: " + overallGrade);
        } else {
            System.out.println("Student not found.");
        }
    }
}
