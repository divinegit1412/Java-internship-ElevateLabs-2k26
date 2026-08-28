package studentManagment;

public class studentmMain {

    public static void main(String[] args) {

        StudentManagement management = new StudentManagement();

        management.add(new Student(1, "John Doe", 85.5f));
        management.add(new Student(2, "Jane Smith", 92.0f));
        management.add(new Student(3, "Bob Johnson", 78.5f));
        management.add(new Student(4, "Alice Williams", 88.0f));
        management.add(new Student(5, "Charlie Brown", 95.5f));

        Student  student = management.view(2);

        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getMarks());
    }
}
