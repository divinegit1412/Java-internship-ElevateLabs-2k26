package studentManagment;

import java.util.ArrayList;

public class StudentManagement {

    private ArrayList<Student> students = new ArrayList<>();

    public void add(Student s) {
        students.add(s);
    }

    public Student view(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public String updateName(int id, String name) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                return "Student details updated successfully!";
            }
        }
        return "Student Not Found!";
    }

    public String updateMarks(int id, float marks) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setMarks(marks);
                return "Student details updated successfully!";
            }
        }
        return "Student Not Found!";
    }

    public String delete(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            return "Student deleted successfully!";
        }

        return "Student Not Found!";
    }
}