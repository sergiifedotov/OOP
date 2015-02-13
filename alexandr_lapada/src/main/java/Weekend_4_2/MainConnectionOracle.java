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
            Connection conn = DriverManager.getConnection(url, "notebook", "notebook");
            Statement stmt =  conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM notebook");

            while(rs.next()){
                Long id = rs.getLong(1);
                String name = rs.getString(3);
                String model = rs.getString(4);
                Long depId = rs.getLong(2);
                //Date date = rs.getDate(5);
                double salary = rs.getDouble(5);
                System.out.println(id+"  "+depId+" "+name+" "+model+" "+salary);

            }


            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
