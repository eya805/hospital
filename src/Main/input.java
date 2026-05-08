package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class input {

    private static Scanner input = new Scanner(System.in);
    // take int and check it
    public static int takeInt(){

        while(true){
            try{
                int value = input.nextInt();
                input.nextLine();  // used to clean up the puffer
                return  value;
            } catch(InputMismatchException e){
                input.nextLine(); // used to clean up the puffer
                return 0;
            }

        }

    }

    // Take String and check it
    public static String takeStr() {

        while (true) {
            try {
                String value = input.nextLine().trim();
                if (value.isBlank()) {
                    throw new Exception("Field can't be empty");
                }
                if (value.matches(".*\\d.*")) {
                    throw new Exception("Field can't be numbers");
                }
                return value;
            } catch (Exception e) {
                System.out.println(e.getMessage() + ", please try again");
            }
        }
    }
}
