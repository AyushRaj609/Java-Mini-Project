import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private float marks;

    public Student(int rollNumber, String name, float marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details of student " + (i+1) + ":");

            System.out.print("Roll Number: ");
            int rollNumber = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Marks: ");
            float marks = sc.nextFloat();

            students[i] = new Student(rollNumber, name, marks);
        }

        for (int i = 0; i < n; i++) {
            students[i].display();
        }

        sc.close();
    }
}
