package session8;

import java.sql.*;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class FetchEx {
    public static void main(String[] args) {
        getAllUsers("SELECT * FROM employees");
        prinntUsersByDep(103);
    }

    private static void prinntUsersByDep(int depId) {
        getAllUsers("SELECT * FROM employees WHERE department_id="+depId);
    }

    private static void getAllUsers(String sql) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e)  {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement st = conn.createStatement();

            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Long id = res.getLong("employee_id");
                String name = res.getString(2);
                System.out.printf("%d \t %s\n", id, name);
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
