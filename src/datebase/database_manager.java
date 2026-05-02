package datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_manager {
    private static final String URL = "jdbc:sqlite:hospital.db";

    public static Connection connect (){
        Connection conn = null ;

    try {
        conn = DriverManager.getConnection(URL);}
    catch (SQLException e){
        System.out.println("Field Connect: "+ e.getMessage());
    }
    return conn;
    }
    public static void initializeDatabase(){
        String CreateDoctorTable = """
                CREATE TABLE IF NOT EXISTS doctors (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                username TEXT NOT NULL,
                password TEXT NOT NULL,
                age INTEGER NOT NULL,
                specialty TEXT NOT NULL)""";
        String createPatientsTable = """
                CREATE TABLE IF NOT EXISTS patients (
                id  INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                username TEXT NOT NULL,
                password TEXT NOT NULL,
                age INTEGER NOT NULL,
                doctor_id INTEGER NOT NULL)""";
        try (Connection conn = connect();
        var x = conn.createStatement()){
            x.execute(CreateDoctorTable);
            x.execute(createPatientsTable);
        } catch (SQLException e ){
            System.out.println("Failed" + e.getMessage());
        }
    }
}