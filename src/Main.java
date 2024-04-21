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

            
        }

    }
}