package session8;

import java.sql.*;
import java.util.Locale;

/**
 * Created by vladimir on 01.02.2015.
 *
 * Вывести всех сотрудников, ID, имя, номер департамента, зарплату.
 */
public class JDBCDemo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, "hr", "hr");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT employee_id, first_name, last_name, department_id, salary FROM employees");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3) + " "
                        + resultSet.getInt(4) + " "
                        + resultSet.getInt(4));
            }

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }


        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
