package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public class Oracle {
    final static String driverName= "oracle.jdbc.OracleDriver";
    final static String DB_CONNECTION="jdbc:oracle:thin:@//localhost:1521/xe";
    final static String DB_USER="hr";
    final static String DB_PASSWORD="hr";


    //создание соединения
    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
    // добавление в табл.
//    public static void insertTable(String ffname, String llname, String eemail) throws SQLException {
//        Statement st=null;
//        Connection getDCB = null;
//
//        try{
//            getDCB= getDBConnection();
//            st= getDCB.createStatement();
//            String insert = "INSERT INTO SERVLET (FNAME, LNAME, EMAIL) VALUES ("+"'"+ ffname +"','" + llname + "','" + eemail + "')";
//            st.executeUpdate (insert);
//        } catch (SQLException e) {
//            e.printStackTrace();  }
//        finally {
//            try {
//                if (st != null) {
//                    st.close();
//                }
//                if (getDCB != null) {
//                    getDCB.close();
//                }
//            }catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    //вызов из таблицы
//
//    public static List<Employee> selectTable()  {
//        List<Employee> employees = new ArrayList<Employee>();
//        Statement st=null;
//        Connection getDB = null;
//        try{
//            getDB= getDBConnection();
//            st= getDB.createStatement();
//            String sel="SELECT FNAME, LNAME, EMAIL,ID_EMPLOYEE FROM SERVLET ORDER BY ID_EMPLOYEE";
//            ResultSet rs=st.executeQuery(sel);
//            while (rs.next()){
//                Employee emp1= new Employee();
//                emp1.setFname(rs.getString("FNAME"));
//                emp1.setLname(rs.getString("LNAME"));
//                emp1.setEmail(rs.getString("EMAIL"));
//                emp1.setIdEmployee(rs.getInt("ID_EMPLOYEE"));
//                employees.add(emp1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                if(st!=null){  st.close();   }
//
//                if (getDB!=null){ getDB.close(); }}
//            catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return employees;
//    }

    //создание таблицы
//       private static void createDbUserTable() throws SQLException {
//        Connection dbConnection = null;
//        Statement statement = null;
//         if ("SELECT COUNT(*) FROM ALL_TABLES WHERE TABLE_NAME='SERVLET'"){}
//        String createTableSQL = "CREATE TABLE SERVLET("
//                + "ID_EMLOYEE NUMBER(5) NOT NULL, "
//                + "FNAME VARCHAR(20) NOT NULL, "
//                + "LNAME VARCHAR(20) NOT NULL, "
//                + "EMAIL VARCHAR(20) NOT NULL, "
//                + "PRIMARY KEY (ID_EMLOYEE) "
//                + ")";
//
//        try {
//            dbConnection = getDBConnection();
//            statement = dbConnection.createStatement();
//            // выполнить SQL запрос
//            statement.execute(createTableSQL);
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (dbConnection != null) {
//                dbConnection.close();
//            }
//        }
}
