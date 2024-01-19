import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

public class StudentGradeTracker {
    private ArrayList<Student> students = new ArrayList<>();
    public void addStudent(String name, int grade) {
        students.add(new Student(name, grade));
    }
    public double calculateAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }

        return (double) sum / students.size();
    }

    public int findHighest() {
        if (students.isEmpty()) {
            return 0;
        }

        ArrayList<Integer> grades = new ArrayList<>();
        for (Student student : students) {
            grades.add(student.getGrade());
        }

        return Collections.max(grades);
    }
    public int findLowest() {
        if (students.isEmpty()) {
            return 0;
        }

        ArrayList<Integer> grades = new ArrayList<>();
        for (Student student : students) {
            grades.add(student.getGrade());
        }

        return Collections.min(grades);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker gradeTracker = new StudentGradeTracker();

        // Get the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Get grades from the teacher
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name for student " + (i + 1) + ": ");
            String name = scanner.next();
            System.out.print("Enter the grade for student " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            gradeTracker.addStudent(name, grade);
        }

        // Calculate and display the average, highest, and lowest scores
        double average = gradeTracker.calculateAverage();
        int highest = gradeTracker.findHighest();
        int lowest = gradeTracker.findLowest();

        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        scanner.close();
    }
}
