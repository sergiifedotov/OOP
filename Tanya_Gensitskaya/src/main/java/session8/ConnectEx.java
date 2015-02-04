package session8;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by ZaR on 01.02.15.
 */
public class ConnectEx {
    public static void main(String[] args)  {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try (Connection conn = DriverManager.getConnection(url, "hr", "hr");){

        }catch (SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }





    }
}
