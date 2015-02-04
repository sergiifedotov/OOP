package Weekend_4_2;



import java.sql.*;
import java.util.Locale;

/**
 * Created by sanya on 01.02.2015.
 */
public class MainConnectionOracle {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); //для ого что бы драйвер работал с виндовсом

        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stmt =  conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE salary = 300");

            while(rs.next()){
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                Long depId = rs.getLong(11);
                double salary = rs.getDouble(8);
                System.out.println(id+"  "+name+"  "+depId+"  "+salary);

            }


            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
