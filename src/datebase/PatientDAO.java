package datebase;
import hospital.Patient;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PatientDAO {

    public static void addPatient(Patient patient){
        String sql = "INSERT INTO patients (name , username ,password , age , doctor_id) VALUES(?,?,?,?,?)";

        try ( Connection conn = database_manager.connect();
        PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1,patient.getName());
            p.setString(2,patient.getUserName());
            p.setString(3,patient.getPassword());
            p.setInt(4, patient.getAge());
            p.setInt(5,patient.getDoctor_id());
            p.executeUpdate();

            var keys = p.getGeneratedKeys();
            if (keys.next()){
                patient.setId(keys.getInt(1));
            }

            System.out.println("register is Done");
        } catch(SQLException e ) {
            System.out.println("Failed"+e.getMessage());
        }
    }

    public static Patient login(String username, String password){
        String sql = "SELECT * FROM patients WHERE username = ? AND password = ?";
        try (Connection conn = database_manager.connect();
        PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1,username);
            p.setString(2,password);

            var rs = p.executeQuery();

            if (rs.next()){
                Patient patient = new Patient(
                     rs.getString("name"),
                     rs.getString("username"),
                     rs.getString("password"),
                     rs.getInt("age"),
                     rs.getInt("doctor_id"));

                patient.setId(rs.getInt("id"));
                return patient;
            }

        } catch (SQLException e ){
            System.out.println("login Error"+e.getMessage());
        }
        return null ;
    }

    public static void updatePassword(Patient patient){
        String sql = "UPDATE patients SET password = ? WHERE id = ?";
        try (Connection conn = database_manager.connect();
             PreparedStatement p = conn.prepareStatement(sql)){
            p.setString(1, patient.getPassword());
            p.setInt(2, patient.getId());
            p.executeUpdate();
            System.out.println("Password updated.");
        } catch (SQLException e){
            System.out.println("Failed" + e.getMessage());
        }
    }

    public static void updateAge(Patient patient){
        String sql = "UPDATE patients SET age = ? WHERE id = ?";
        try (Connection conn = database_manager.connect();
             PreparedStatement p = conn.prepareStatement(sql)){
            p.setInt(1, patient.getAge());
            p.setInt(2, patient.getId());
            p.executeUpdate();
        } catch (SQLException e){
            System.out.println("Failed" + e.getMessage());
        }
    }
}
