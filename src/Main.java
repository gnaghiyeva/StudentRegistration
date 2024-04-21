import Entities.Student;
import Entities.University;

import java.util.Scanner;

import static Helpers.Colors.*;
import static Helpers.Logo.WriteTextWithLetters;
import static Helpers.Helper.ConvertParseInt;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        University university;
        Scanner scanner = new Scanner(System.in);
        String universityName = WriteTextWithLetters("");
        university=new University(universityName);

        System.out.println();
        System.out.println(BOLD_TEXT+"Seçim etmək üçün 1 ilə 6 arası bir ədəd daxil edin"+ANSI_RESET);

        while (true){
            System.out.println(ANSI_PURPLE+"1. Tələbə əlavə edin: "+ANSI_RESET);
            System.out.println(ANSI_CYAN+"2. Bütün tələbələri göstərin: "+ANSI_RESET);
            System.out.println(ANSI_BLUE+"3. Tələbəni silmək: "+ANSI_RESET);
            System.out.println(ANSI_YELLOW+"4. Tələbəni tapmaq: "+ANSI_RESET);
            System.out.println(ANSI_WHITE+"5. Tələbənin məlumatlarını dəyişdirmək: "+ANSI_RESET);
            System.out.println(ANSI_CYAN+"6. Tələbənin axtarışı: "+ANSI_RESET);
            System.out.println(ANSI_YELLOW+"7. Fakültənin tələbələrini tapmaq: "+ANSI_RESET);
            System.out.println("8. Exit ");

            String operation = scanner.nextLine();
            int operationNumber = 0;
            if(operation.isEmpty() || operation.isBlank()){
                System.out.println("Operation bos ola bilmez");
            } else if (operationNumber<0) {
                System.out.println("Seçim mənfi ola bilməz!");
            }
            try {
                operationNumber =  Integer.parseInt(operation);
            }catch (Exception e){
                System.out.println("Reqem daxil et: ");
            }

            if (operationNumber == 1) {
                Scanner sc = new Scanner(System.in);
                int num;
                do {
                    System.out.print("Neçə Tələbə əlavə etmək istəyirsiniz?");
                    while (!sc.hasNextInt()) {
                        System.out.println("Düzgün bir sayı daxil edin.");
                        sc.next();
                    }
                    num = sc.nextInt();
                    sc.nextLine();
                    if (num <= 0) {
                        System.out.println("Ən az bir tələbə əlavə etməlisiniz.");
                    }
                } while (num <= 0);

                for (int i = 1; i <= num; i++) {
                    String studentName;
                    do {
                        System.out.println(ANSI_WHITE+"Prosesi dayandırmaq üçün" +ANSI_GREEN+"  done   "+ANSI_RESET+"yazın"+ANSI_RESET);
                        System.out.print(i + "-ci tələbənin adı:");
                        studentName = sc.nextLine();
                        if (studentName.isEmpty()||studentName.isBlank()||studentName.matches(".*\\d.*") ||  studentName.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || studentName.contains(".") ) {
                            System.out.println("Düzgün ad daxil edin.");
                        }
                    } while (studentName.isEmpty()||studentName.isBlank()||studentName.matches(".*\\d.*") || studentName.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || studentName.contains("."));
                    if (studentName.equalsIgnoreCase("done")){
                        System.out.println(ANSI_RED+"Əməliyyat dayandırıldı"+ANSI_RESET);
                        break;
                    }

                    String studentSurname;
                    do {
                        System.out.print(i + "-ci tələbənin Soyadı:");
                        studentSurname = sc.nextLine();
                        if (studentSurname.isEmpty()||studentSurname.isBlank()||studentSurname.matches(".*\\d.*") || studentSurname.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || studentSurname.contains(".") ) {
                            System.out.println("Düzgün soyad daxil edin.");
                        }
                    } while (studentSurname.isEmpty()||studentSurname.isBlank()||studentSurname.matches(".*\\d.*") || studentSurname.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || studentSurname.contains("."));

                    if (studentSurname.equalsIgnoreCase("done")){
                        System.out.println(ANSI_RED+"Əməliyyat dayandırıldı"+ANSI_RESET);
                        break;
                    }

                    String studentFIN;
                    do {
                        System.out.print(i + "-ci tələbənin Fin kodu: ");
                        studentFIN = sc.nextLine();

                        if (university.isDuplicateFIN(studentFIN)) {
                            System.out.println("Bu Fin kodu artıq mövcuddur. Başqa Fin kodu daxil edin.");
                        } else if (!studentFIN.matches("[A-Za-z0-9]+")) {
                            System.out.println("Düzgün Fin daxil edin.");
                        } else if (studentFIN.length() != 7) {
                            System.out.println("Fin kodun uzunluğu 7 olmalıdır.");
                        } else if (studentFIN.isEmpty() || studentFIN.isBlank()) {
                            System.out.println("Fin kod boş ola bilməz.");
                        }else if (studentFIN.matches("[a-zA-Z]+")) {
                            System.out.println("Fin kod ancaq hərflərdən ibarət ola bilməz");
                        } else if (studentFIN.matches("^[0-9]+$")) {
                            System.out.println("Fin kod ancaq rəqəmlərdən ibarət ola bilməz");
                        }else {
                            break;
                        }
                    } while (true);

                    if (studentFIN.equalsIgnoreCase("done")) {
                        System.out.println(ANSI_RED+"Əməliyyat dayandırıldı"+ANSI_RESET);
                        break;
                    }

                    int studentAge;
                    String ageInput;
                    do {
                        System.out.print(i + "-ci tələbənin yaş:");
                        ageInput = sc.nextLine();
                        try {
                            studentAge = Integer.parseInt(ageInput);
                            if (studentAge < 0) {
                                System.out.println("Yaş mənfi ola bilməz.");
                            } else if (studentAge < 16) {
                                System.out.println("Yaş ən azı 16 olmalıdır.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Düzgün yaş daxil edin.");
                        }
                    } while (true);

                    if(ageInput.equalsIgnoreCase("done")){
                        System.out.println(ANSI_RED+"Əməliyyat dayandırıldı"+ANSI_RESET);
                        break;
                    }
                    String studentFaculty;
                    do {
                        System.out.print(i + "-ci tələbənin Fakültəsi:");
                        studentFaculty = sc.nextLine();
                        if (studentFaculty.isEmpty()||studentFaculty.isBlank()||studentFaculty.matches(".*\\d.*") || studentFaculty.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || studentFaculty.contains(".")) {
                            System.out.println("Düzgün fakültə adı daxil edin.");
                        }
                    } while (studentFaculty.isEmpty()||studentFaculty.isBlank()||studentFaculty.matches(".*\\d.*") ||  studentFaculty.matches(".*[<>\\/\\\\'\\[\\];:@\"\\\\*%#$()!^&_=+\\-№?|{}].*") || studentFaculty.contains("."));
                    if (studentFaculty.equalsIgnoreCase("done")){
                        System.out.println(ANSI_RED+"Əməliyyat dayandırıldı"+ANSI_RESET);
                        break;
                    }
                    university.AddStudent(new Student(studentName, studentSurname, studentFaculty, studentFIN,studentAge));
                }
            }

            else if (operationNumber==2) {
                university.showAllStudents();
            }
            else if (operationNumber==3) {
                university.RemoveStudent();
            }

        }

    }
}