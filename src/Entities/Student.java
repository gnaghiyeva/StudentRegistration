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

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getFaculty() {
        return Faculty;
    }

    public int getAge() {
        return Age;
    }

    public String getFIN() {
        return FIN;
    }

    public void fullInfo(){
        System.out.println(Name+" "+Surname+", " +Faculty+" fakültəsi, "+FIN+", "+Age+ "yaş ");
    }


    public void setName(String newName) {
        Name = newName;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public void setAge(int newAge) {
        Age = newAge;
    }

    public void setFIN(String fin) {
        FIN = fin;
    }

}
