package Entities;

public class Student {
    public Student() {
    }

    private static int id;
    private  int Id;
    public String Name;
    public String Surname;
    public int Age;
    public String Faculty;
    public String FIN;

    public Student(String name, String surname,String faculty, String fin, int age){
        id++;

        Id=id;
        Name=name;
        Surname=surname;
        Faculty=faculty;
        Age=age;
        FIN=fin;
    }
}
