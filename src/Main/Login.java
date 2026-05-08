package Main;

import datebase.DoctorDAO;
import datebase.PatientDAO;
import hospital.Doctor;
import hospital.Patient;

public class Login {
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
