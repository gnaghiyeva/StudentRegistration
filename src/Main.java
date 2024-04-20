import Entities.University;

import java.util.Scanner;

import static Helpers.Logo.WriteTextWithLetters;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        University university;
        Scanner scanner = new Scanner(System.in);
        String universityName = WriteTextWithLetters("");
        university=new University(universityName);

    }
}