package main.java.session8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class ConnectEx {
    public static void main(String[] args) {
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

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try (Connection conn = DriverManager.getConnection(url, "hr", "hr");){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
