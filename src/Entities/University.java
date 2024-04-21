package Entities;

import java.util.ArrayList;

import static Helpers.Colors.ANSI_GREEN;
import static Helpers.Colors.ANSI_RESET;

public class University {
    private int Id;
    private static int id = 0;

    private ArrayList<Student> students;
    public String Name;
    public int Age;

    public University(String name) {
        id++;
        Id = id;
        Name = name;
        students = new ArrayList<>();
    }
    public int getId() {
        return Id;
    }


    public void AddStudent(Student student) {
        students.add(student);
        System.out.println(ANSI_GREEN + "Tələbə uğurla əlavə edildi" + ANSI_RESET);
        Age += student.Age;
    }

    public boolean isDuplicateFIN(String fin) {
        for (Student student : students) {
            if (student.getFIN().equals(fin)) {
                return true;
            }
        }
        return false;
    }
}
