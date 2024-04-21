package Entities;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void RemoveStudent() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);


        if (students.isEmpty()) {
            System.out.println(ANSI_YELLOW + "Heç bir tələbə əlavə olunmayıb" + ANSI_RESET);
        } else {
            System.out.print("Silmək istədiyiniz tələbənin finkodunu daxil edin: ");
            String inputFIN = scanner.nextLine();
            for (int i = 0; i < students.size(); i++) {
                student = students.get(i);
                if (student.getFIN().equals(inputFIN)) {
                    students.remove(i);
                    System.out.println(ANSI_GREEN + "Tələbə uğurla silindi." + ANSI_RESET);
                    return;
                }
            }
            System.out.println(ANSI_RED + "Bu FIN koduna uyğun tələbə tapılmadı." + ANSI_RESET);

        }

    }

    public String FindStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tələbənin finkodunu daxil edin: ");
        String inputFIN = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getFIN().equalsIgnoreCase(inputFIN)) {
                System.out.println("Axtarılan tələbə adı: " + student.getName() + ",  soyadı: " + student.getSurname() + ", yaşı: " + student.getAge());
                found = true;
                //return inputFIN;
            } else if (student.getFIN().isEmpty()) {
                System.out.println("FİN boş ola bilməz");
            }

        }

        if (found != true) {
            System.out.println(ANSI_RED + "Tələbə tapılmadı" + ANSI_RESET);
        }
        return inputFIN;
    }


}
