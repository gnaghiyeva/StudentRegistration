package Entities;

import java.util.ArrayList;

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
}
