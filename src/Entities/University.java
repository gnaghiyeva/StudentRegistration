package Entities;

import java.util.ArrayList;

import static Helpers.Colors.*;

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

    //Bütün tələbələrin göstərilməsi
    public void showAllStudents() {
        System.out.println("************* T ə l ə b ə l ə r i n   S i y a h ı s ı *************");
        if (students.isEmpty()) {
            System.out.println(ANSI_YELLOW + "Heç bir tələbə əlavə olunmayıb" + ANSI_RESET);
        } else {
            for (Student student : students) {
                student.fullInfo();
            }
        }

    }
}
