package datebase;
import hospital.Doctor;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorDAO {

    public static void addDoctor(Doctor d) {
        String sql = "INSERT INTO doctors (name, username , password, age , specialty) VALUES (?,?,?,?,?)";
        try( Connection conn = database_manager.connect();
             PreparedStatement p = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            p.setString(1,d.getName());
            p.setString(2,d.getUserName());
            p.setString(3,d.getPassword());
            p.setInt(4,d.getAge());
            p.setString(5,d.getSpecialty());
            p.executeUpdate();

            // ✅ جايب الـ ID من الـ DB وبيحطه في الـ object
            var keys = p.getGeneratedKeys();
            if (keys.next()){
                d.setId(keys.getInt(1));
            }

            System.out.println("register is Done");

        } catch (SQLException e) {
            System.out.println("Failed"+e.getMessage());
        }
    }

    public static Doctor login(String username, String password){
        String sql = "SELECT * FROM doctors WHERE username = ? AND password = ?";
        try (Connection conn = database_manager.connect();
             PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1,username);
            p.setString(2,password);

            var reslut = p.executeQuery();

            if (reslut.next()){
                Doctor d = new Doctor(
                        reslut.getString("name"),
                        reslut.getString("username"),
                        reslut.getString("password"),
                        reslut.getInt("age"),
                        reslut.getString("specialty")
                );
                // ✅ جايب الـ ID من الـ DB
                d.setId(reslut.getInt("id"));
                return d;
            }
        } catch (SQLException e) {
            System.out.println("login Error"+e.getMessage());
        }
        return null;
    }

    public static ArrayList<Doctor> allDoctors(){
        String sql = "SELECT * FROM doctors";
        ArrayList<Doctor> doctors = new ArrayList<>();
        try (Connection conn = database_manager.connect();
             var x = conn.createStatement()){
            var result = x.executeQuery(sql);
            while (result.next()){
                Doctor d = new Doctor(
                        result.getString("name"),
                        result.getString("username"),
                        result.getString("password"),
                        result.getInt("age"),
                        result.getString("specialty")
                );
                // ✅ جايب الـ ID من الـ DB
                d.setId(result.getInt("id"));
                doctors.add(d);
            }
        } catch (SQLException e){
            System.out.println("Failed" + e.getMessage());
        }
        return doctors;
    }

    public static void updatePassword(Doctor d){
        String sql = "UPDATE doctors SET password = ? WHERE id = ?";
        try (Connection conn = database_manager.connect();
             PreparedStatement p = conn.prepareStatement(sql)){
            p.setString(1, d.getPassword());
            p.setInt(2, d.getId());
            p.executeUpdate();
            System.out.println("Password updated.");
        } catch (SQLException e){
            System.out.println("Failed" + e.getMessage());
        }
    }

    public static void updateAge(Doctor d){
        String sql = "UPDATE doctors SET age = ? WHERE id = ?";
        try (Connection conn = database_manager.connect();
             PreparedStatement p = conn.prepareStatement(sql)){
            p.setInt(1, d.getAge());
            p.setInt(2, d.getId());
            p.executeUpdate();
        } catch (SQLException e){
            System.out.println("Failed" + e.getMessage());
        }
    }

    public static void updateSpecialty(Doctor d){
        String sql = "UPDATE doctors SET specialty = ? WHERE id = ?";
        try (Connection conn = database_manager.connect();
             PreparedStatement p = conn.prepareStatement(sql)){
            p.setString(1, d.getSpecialty());
            p.setInt(2, d.getId());
            p.executeUpdate();
        } catch (SQLException e){
            System.out.println("Failed" + e.getMessage());
        }
    }

}