import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setMarks(int m) {
        marks = m;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class Student_Record_Management_System {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Add Student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // duplicate check
        if (findStudentById(id) != null) {
            System.out.println("Student with this ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        Student s = new Student(id, name, marks);
        list.add(s);

        System.out.println("Student added successfully!");
    }

    // View Students
    public static void viewStudents() {
        if (list.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    // Update Student
    public static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudentById(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter new Name: ");
        String newName = sc.nextLine();

        System.out.print("Enter new Marks: ");
        int newMarks = sc.nextInt();

        s.setName(newName);
        s.setMarks(newMarks);

        System.out.println("Student updated successfully!");
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Find Student by ID
    public static Student findStudentById(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
