import java.util.*;

class Student {
    int id;
    String name;
    String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Course: " + course);
    }
}

public class StudentDatabaseApp {
    private static Map<Integer, Student> studentDB = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();

        Student s = new Student(id, name, course);
        studentDB.put(id, s);
        System.out.println("Student added successfully.");
    }

    public static void viewStudents() {
        if (studentDB.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : studentDB.values()) {
                s.display();
            }
        }
    }

    public static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        if (studentDB.containsKey(id)) {
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new course: ");
            String course = sc.nextLine();
            studentDB.put(id, new Student(id, name, course));
            System.out.println("Student record updated.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Database Application");
            System.out.println("1. Add Student\n2. View Students\n3. Update Student\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}
