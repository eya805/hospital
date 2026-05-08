package Main ;

//import Main.input;
import datebase.DoctorDAO;
import datebase.PatientDAO;
import hospital.Doctor;
import hospital.Patient;

public class service {

    public static void serviceDr(Doctor d){
        while(true){
            System.out.println("""
                    enter num of service:
                    1- change password
                    2- change age
                    3- change specialty
                    4- exit""");

            int choice = input.takeInt();

            if(choice == 1){
                System.out.println("Enter New Password");
                d.setPassword(input.takeStr());
                DoctorDAO.updatePassword(d);
            } else if (choice == 2){
                System.out.println(" Enter New Age");
                d.setAge(input.takeInt());
                DoctorDAO.updateAge(d);
            } else if (choice == 3){
                System.out.println(" Enter New Specialty");
                d.setSpecialty(input.takeStr());
                DoctorDAO.updateSpecialty(d);
            }else if (choice == 4){
                break;
            } else {
                System.out.println("Wrong choice select a num from 1 to 4");
            }
        }
    }

    public static void servicePatient(Patient p) {
        while (true) {
            System.out.println("""
                    enter num of service:
                    1- change password
                    2- change age
                    3- exit""");
            int choice = input.takeInt();
            if (choice == 1) {
                System.out.println("Enter New Password");
                p.setPassword(input.takeStr());
                PatientDAO.updatePassword(p);
            } else if (choice == 2) {
                System.out.println("Enter New Age");
                p.setAge(input.takeInt());
                PatientDAO.updateAge(p);
                System.out.printf("age updated %d",p.getAge());
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Wrong choice select a num from 1 to 4");
            }
        }
    }
}