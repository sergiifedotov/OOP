package session7_8;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Chuvychin on 01.02.2015.
 */
public class DataBaseConn {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Connection conn = null;




        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT employee_id, first_name, last_name, salary FROM employees");
            while (rs.next()){
                long id = rs.getLong(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                long salary = rs.getLong(4);
                System.out.printf("%d \t %s \t %s \t %s \n", id, firstName, lastName, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        try {
            conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
        }

    }

}

