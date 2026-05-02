import java.util.InputMismatchException;
import java.util.Scanner;

public class input {

    // take int and check it
    public static int takeInt(){
        Scanner input = new Scanner(System.in);
        while(true){
            try{
                return  input.nextInt();
            } catch(InputMismatchException e){
                return 0;
            }

        }

    }

    // Take String and check it
    public static String takeStr() {
        Scanner input = new Scanner(System.in);
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
