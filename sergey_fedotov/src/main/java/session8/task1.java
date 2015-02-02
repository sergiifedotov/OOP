package session8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by warit on 01.02.2015.
 */
public class task1 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

/*        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(ClassNotFoundException e){
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }*/
        Connection conn = null;
        System.out.println("JDBC driver is loaded:");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
        }catch (SQLException e)
        {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try {conn.close();}
                catch (SQLException e){}
            }
        }

    }


}
