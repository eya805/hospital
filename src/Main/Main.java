package Main;

import datebase.database_manager;

public class Main {
    public static void main(String[]args){
        database_manager.initializeDatabase(); // create DB
        while (true){

            System.out.println("Welcome to the hospital system");

            System.out.println("""
             choose your options:
             1- Register
             2- login
             3- Exit""");

            int choice1 = input.takeInt();

            if (choice1==1){
                Register.register();
            } else if(choice1==2){
                Login.login();
            } else if (choice1 == 3){
                break;
            } else {
                System.out.println("Wrong choice ");
            }
        }
    }
}

