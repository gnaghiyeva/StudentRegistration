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

    public void UpdateStudent() {
        Scanner scanner = new Scanner(System.in);
        String searchId;

        do {
            System.out.print("Məlumatlarını dəyişdirmək istədiyiniz tələbənin finkodunu daxil edin: ");
            searchId = scanner.nextLine();

            if (!searchId.matches("[A-Za-z0-9]+")) {
                System.out.println("Düzgün bir ID daxil edin.");
            }
        } while (!searchId.matches("[A-Za-z0-9]+"));

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getFIN().equalsIgnoreCase(searchId)) {
                found = true;
                System.out.println("Hazırkı tələbənin məlumatları:");
                System.out.println(ANSI_CYAN+student.getSurname() + " " + student.getName() + " " + student.getAge() + " yaş  " + student.getFIN() + " " + student.getFaculty()+ANSI_RESET);

                System.out.println(BOLD_TEXT+"Hansı məlumatı dəyişdirmək istəyirsiniz?"+ANSI_RESET);
                System.out.println(ANSI_GREEN+"1. Ad"+ANSI_RESET);
                System.out.println(ANSI_YELLOW+"2. Soyad"+ANSI_RESET);
                System.out.println(ANSI_BLUE+"3. Fakültə"+ANSI_RESET);
                System.out.println(ANSI_PURPLE+"4. FIN kod"+ANSI_RESET);
                System.out.println(ANSI_RED+"5. Yaş"+ANSI_RESET);

                int choice;
                do {
                    System.out.print("Seçiminizi daxil edin:(siyahıdakı nömrələrə uyğun olaraq) ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("1-5 arasında bir rəqəm daxil edin.");
                        scanner.next();
                    }
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 5) {
                        System.out.println("1-5 arasında bir rəqəm daxil edin.");
                    }
                } while (choice < 1 || choice > 5);

                scanner.nextLine();

                switch (choice) {
                    case 1:
                        String newName;
                        do {
                            System.out.print(ANSI_CYAN + "Yeni ad: " + ANSI_RESET);
                            newName = scanner.nextLine();
                            if (newName.matches(".*\\d.*") || newName.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || newName.contains(".")) {
                                System.out.println("Düzgün bir ad daxil edin.");
                            } else if (newName.isEmpty() || newName.isBlank()) {
                                System.out.println("Ad boş ola bilməz!");
                            }
                        } while (newName.matches(".*\\d.*") || newName.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || newName.contains(".") || newName.isEmpty() || newName.isBlank());
                        student.setName(newName);
                        break;

                    case 2:
                        String newSurname;
                        do {
                            System.out.print(ANSI_CYAN + "Yeni soyad: " + ANSI_RESET);
                            newSurname = scanner.nextLine();
                            if (newSurname.matches(".*\\d.*") || newSurname.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || newSurname.contains(".")) {
                                System.out.println("Düzgün bir soyad daxil edin.");
                            } else if (newSurname.isEmpty() || newSurname.isBlank()) {
                                System.out.println("Soyad boş ola bilməz!");
                            }
                        } while (newSurname.matches(".*\\d.*") || newSurname.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || newSurname.contains(".") || newSurname.isEmpty() || newSurname.isBlank());
                        student.setSurname(newSurname);
                        break;
                    case 3:
                        String newFaculty;
                        do {
                            System.out.print(ANSI_CYAN + "Yeni Fakültə: " + ANSI_RESET);
                            newFaculty = scanner.nextLine();
                            if (newFaculty.matches(".*\\d.*") || newFaculty.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || newFaculty.contains(".")) {
                                System.out.println("Düzgün bir fakültə daxil edin.");
                            } else if (newFaculty.isEmpty() || newFaculty.isBlank()) {
                                System.out.println("Fakültə boş ola bilməz!");
                            }
                        } while (newFaculty.matches(".*\\d.*") || newFaculty.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || newFaculty.contains(".") || newFaculty.isEmpty() || newFaculty.isBlank());
                        student.setFaculty(newFaculty);
                        break;
                    case 4:
                        String newFIN;
                        String oldFIN;

                        do {
                            oldFIN = student.getFIN();
                            System.out.print(ANSI_CYAN + "Yeni FIN kod: " + ANSI_RESET);
                            newFIN = scanner.nextLine();
                            if (!newFIN.matches("[A-Za-z0-9]+")) {
                                System.out.println("Fin kod yalnız hərf və rəqəmlərdən ibarət olmalıdır.");
                            } else if (newFIN.length() != 7) {
                                System.out.println("Fin kodun uzunluğu 7 olmalıdır.");
                            } else if (oldFIN.equals(newFIN)) {
                                System.out.println("Güncəllənən FIN kod daha əvvəl mövcud olub yenisini daxil edin");
                            } else if (newFIN.isEmpty() || newFIN.isBlank()) {
                                System.out.println("Fin kod boş ola bilməz.");
                            } else if (newFIN.matches("[a-zA-Z]+")) {
                                System.out.println("Fin kod ancaq hərflərdən ibarət ola bilməz");
                            } else if (newFIN.matches("^[0-9]+$")) {
                                System.out.println("Fin kod ancaq rəqəmlərdən ibarət ola bilməz");
                            } else {
                                student.setFIN(newFIN);
                                System.out.println(ANSI_GREEN + "Tələbənin məlumatları uğurla yeniləndi." + ANSI_RESET);
                                break;
                            }
                        } while (true);
                        break;

                    case 5:
                        System.out.print(ANSI_CYAN + "Yeni yaş: " + ANSI_RESET);
                        int newAge;
                        while (true) {
                            while (!scanner.hasNextInt()) {
                                System.out.println("Keçərli bir yaş daxil edin.");
                                System.out.print(ANSI_CYAN + "Yeni yaş: " + ANSI_RESET);
                                scanner.next();
                            }
                            newAge = scanner.nextInt();
                            if (newAge > 16) {
                                scanner.nextLine();
                                student.setAge(newAge);
                                System.out.println(ANSI_GREEN + "Tələbənin məlumatları uğurla yeniləndi." + ANSI_RESET);
                                break;
                            } else {
                                System.out.println(ANSI_RED + "Yaş mənfidir vəya 16dan kiçikdir. Düzgün yaş daxil edin." + ANSI_RESET);
                                System.out.print(ANSI_CYAN + "Yeni yaş: " + ANSI_RESET);
                            }
                        }
                        break;
                }
            }
        }

        if (!found) {
            System.out.println(ANSI_RED + searchId + " id-li tələbə tapılmadı." + ANSI_RESET);
        }
    }


}
