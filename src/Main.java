import datebase.DoctorDAO;
import datebase.PatientDAO;
import datebase.database_manager;
import hospital.Doctor;
import hospital.Patient;

import java.util.ArrayList;

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
                    if (choice1==1){register();}
                    else if(choice1==2){login();}
                    else if (choice1 == 3){break;}
                    else {
                        System.out.println("Wrong choice ");
                    }
                }
             }


            public static void register(){

                System.out.println("""
                choose:
                1-Doctor
                2-patiant""");

                int type = input.takeInt();
                if (type == 1){

                    System.out.println("welcome to dashboard Doctor");

                    System.out.println("Enter your Name");
                    String name = input.takeStr();

                    System.out.println("Enter your age");
                    int age = input.takeInt();

                    System.out.println("Enter your username");
                    String username = input.takeStr();

                    System.out.println("Enter your password");
                    String password = input.takeStr();

                    System.out.println("Enter your specialty");
                    String specialty = input.takeStr();

                    Doctor d = new Doctor(name , username, password, age,specialty);
                    DoctorDAO.addDoctor(d);

                } else if (type == 2) {
                    System.out.println("welcome to dashboard patient");

                    System.out.println("Enter your Name");
                    String name = input.takeStr();

                    System.out.println("Enter your age");
                    int age = input.takeInt();

                    System.out.println("Enter your username");
                    String username = input.takeStr();

                    System.out.println("Enter your password");
                    String password = input.takeStr();

                    System.out.println("enter the num of your Dr. ");

                    ArrayList<Doctor> doctors = DoctorDAO.allDoctors();
                    if (doctors.isEmpty()){
                        System.out.println("No doctors available");
                        return;}

                    for (int i = 0; i < doctors.size(); i++){
                        System.out.println((i+1) + "- " + doctors.get(i).getName() + "\n" + doctors.get(i).getSpecialty());
                    }

                    int doctornum = input.takeInt();

                    if (doctornum < 1 || doctornum > doctors.size()){
                        System.out.println("Wrong choice");
                        return;
                    }
                    Doctor chosenDoctor = doctors.get(doctornum - 1);

                    Patient p = new Patient(name, username, password, age, chosenDoctor.getId());
                    PatientDAO.addPatient(p);

                } else {
                    System.out.println("Wrong choice please type 1 for Doctor or 2 for Patient");
                }
            }

            public static void login(){
                System.out.println("""
                choose:
                1-Doctor
                2-patiant""");

                int type = input.takeInt();
                if (type == 1){
                    System.out.println("enter your Username");
                    String username = input.takeStr();
                    System.out.println("enter your Password");
                    String password = input.takeStr();
                    Doctor d = DoctorDAO.login(username, password);

                    if (d == null){
                        System.out.println("the user isn't exist");
                        return;
                    }
                    System.out.println(d);
                    service.serviceDr(d);
                } else if (type == 2){
                    System.out.println("enter your Username");
                    String username = input.takeStr();
                    System.out.println("enter your Password");
                    String password = input.takeStr();

                    Patient p = PatientDAO.login(username,password);



                    if (p== null){
                        System.out.println("the user isn't exist");
                        return;
                    }
                    System.out.println(p);
                    service.servicePatient(p);

                } else {
                    System.out.println("Wrong try again");
                }

            }
}

