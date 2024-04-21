package Helpers;

public class Helper {
    public static void  ConvertParseInt(String operation){
        int operationNumber;
        try {
            operationNumber =  Integer.parseInt(operation);
        }catch (Exception e){
            System.out.println("Reqem daxil et: ");
        }
    }
}
