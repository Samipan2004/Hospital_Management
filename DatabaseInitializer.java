import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:Hospital.db";
        //Doctor Table
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS doctor ("
                        + "did INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "dname TEXT, "
                        + "specialist TEXT, "
                        + "appoint TEXT, "
                        + "doc_qual TEXT, "
                        + "droom INTEGER"
                        + ");";
                stmt.execute(createTableSQL);
                System.out.println("Doctor table created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Doctor table error: " + e.getMessage());
        }
        //Patient Table
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS patient ("
                        + "pid INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "pname TEXT, "
                        + "disease TEXT, "
                        + "sex TEXT, "
                        + "admit_status TEXT, "
                        + "age INTEGER"
                        + ");";
                stmt.execute(createTableSQL);
                System.out.println("Patient table created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Patient table error: " + e.getMessage());
        }
        //Diagnostic Table
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS diagnostic ("
                        + "fid INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "facility TEXT, "
                        + "cost INTEGER"
                        + ");";
                stmt.execute(createTableSQL);
                System.out.println("Diagnostic table created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Diagnostic table error: " + e.getMessage());
        }
        //Medicine Table
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS medicine ("
                        + "medid INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "medname TEXT, "
                        + "medcomp TEXT, "
                        + "expdate TEXT, "
                        + "medcost INTEGER, "
                        + "count INTEGER"
                        + ");";
                stmt.execute(createTableSQL);
                System.out.println("Medical table created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Medical table error: " + e.getMessage());
        }
        //Staff Table
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS staff ("
                        + "sid INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "sname TEXT, "
                        + "desg TEXT, "
                        + "sex TEXT, "
                        + "salary INTEGER"
                        + ");";
                stmt.execute(createTableSQL);
                System.out.println("Staff table created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Staff table error: " + e.getMessage());
        }
    }
}
