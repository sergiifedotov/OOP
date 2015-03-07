package session8;

import java.sql.*;
import java.util.Locale;

/**
 * Created by stan on 01.02.15.
 */
public class JDBCConn {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
        System.out.println("JDBC driver is loaded!");


        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try(Connection conn = DriverManager.getConnection(url, "hr", "hr");){
            Statement stmt = conn.createStatement();

            stmt.executeQuery("select first_name, salary, department_id");
            ResultSet rs = stmt.executeQuery("select first_name, salary, department_id");


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
