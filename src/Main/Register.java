package Main;

import datebase.DoctorDAO;
import datebase.PatientDAO;
import hospital.Doctor;
import hospital.Patient;
import java.util.ArrayList;
public class Register {

    public static void register() {

        System.out.println("""
                choose:
                1-Doctor
                2-patiant""");

        int type = input.takeInt();
        if (type == 1) {

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

            Doctor d = new Doctor(name, username, password, age, specialty);
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
            if (doctors.isEmpty()) {
                System.out.println("No doctors available");
                return;
            }

            for (int i = 0; i < doctors.size(); i++) {
                System.out.printf("%d- %s (%s)",(i+1),doctors.get(i).getName(),doctors.get(i).getSpecialty());
            }

            int doctornum = input.takeInt();

            if (doctornum < 1 || doctornum > doctors.size()) {
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
}
