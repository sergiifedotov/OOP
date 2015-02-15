package main.java;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.Locale;

/**
 * Created by user on 01.02.2015.
 */
public class session8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name,  employee_id, department_id, salary FROM employees");
            while(rs.next()){
                Long id = rs.getLong("employee_id");
                String name = rs.getString("first_name");
                String department = rs.getString("department_id");
                Long salary = rs.getLong("salary");
                System.out.printf("%d \t %s \t %s \t %d \n ", id, name, department, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            {

            }

        }
    }
}
