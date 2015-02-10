package hw4.sql;

import java.sql.*;
import java.util.Locale;

/**
 * С помощью язка запросов SQL написать следующие запросы:
 * <p/>
 * 1) Получить одну колонку из таблицы employees
 * 2) Получить одну колонку из таблицы employees без дубликатов
 * 3) Получить налог в 10% с зарплаты сотрудников за месяц
 * 4) Получить имена сотрудников, работающих с 01.01.1982
 * 5) Получить имена сотрудников с зарплатой, меньшей, чем комиссионные
 * 6) Получить имена сотрудников с зарплатой и кодом руководителя,
 * для которых этот код принимает одно из значений 114, 121, 205
 * 7) Получить имена сотрудников, у которых в имени вторая буква = m,
 * а предпоследняя буква = t
 * 8) Получить имя, должность сотрудников, должность которых не входит в список: 'ST_CLERK','IT_PROG','MK_MAN'
 * 9) Получить сотрудников в порядке возрастания дат зачисления на работу
 * <p/>
 * Запросы оформить в виде комментариев в классе hw4.sql.Queries
 */
public class Queries {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "hr";
    private static final String DB_PASSWORD = "hr";

// соединение с БД.
    public  static Connection getDBConnection() {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, DB_USER,DB_PASSWORD);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //
    private static void createDbUserTable() throws SQLException {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = getDBConnection();
            statement = conn.createStatement();

// 0) Вывести idEmployee + " " + firstName + " " + departmentId + " " + salary

//           ResultSet rs = statement.executeQuery("SELECT * FROM employees");
//            while (rs.next()){
//                long idEmployee = rs.getLong(1);
//                String firstName = rs.getString(2);
//                long departmentId = rs.getLong(11);
//                long salary = rs.getLong(1);
//                System.out.println(idEmployee + " " + firstName + " " + departmentId + " " + salary);
//            }
// 1) Получить одну колонку из таблицы employees
//            ResultSet rs = statement.executeQuery("SELECT EMPLOYEE_ID FROM employees");
//            while (rs.next()){
//                long employeeId = rs.getLong(1);
//                System.out.println(employeeId);
//            }
// 2) Получить одну колонку из таблицы employees без дубликатов
//            ResultSet rs = statement.executeQuery("SELECT DEPARTMENT_ID FROM employees");
//            HashMap<Integer, Integer> hm = new HashMap<>();
//            while (rs.next()){
//                Integer employeeId =  new Integer(rs.getInt(1));
//                hm.put(employeeId, null);
//            }
//            for (HashMap.Entry<Integer, Integer> i : hm.entrySet()) {
//                Integer key = i.getKey();
//                Integer value = i.getValue();
//                System.out.println(key + " " + value);
//            }
// 3) Получить налог в 10% с зарплаты сотрудников за месяц
//            ResultSet rs = statement.executeQuery("SELECT SALARY FROM employees");
//            while (rs.next()){
//                double tax = rs.getLong(1)*0.1;
//                System.out.println(tax);
//            }
// 4) Получить имена сотрудников, работающих с 01.01.1982
//            ResultSet rs = statement.executeQuery("SELECT HIRE_DATE FROM employees WHERE HIRE_DATE < '01-JUN-92' ");
//            while (rs.next()){
//                String date = rs.getString(1);
//                System.out.println(date);
//            }
// 5) Получить имена сотрудников с зарплатой, меньшей, чем комиссионные ????



// 6) Получить имена сотрудников с зарплатой и кодом руководителя,
//    для которых этот код принимает одно из значений 114, 121, 205
//            ResultSet rs = statement.executeQuery(
//                    "SELECT FIRST_NAME, LAST_NAME, SALARY, MANAGER_ID  "+
//                            "FROM employees "+
//                            "WHERE MANAGER_ID = 114 OR MANAGER_ID = 121 OR MANAGER_ID = 205");
//            while (rs.next()){
//                String firstName = rs.getString(1);
//                String lastName = rs.getString(2);
//                long salary = rs.getLong(3);
//                long managerId = rs.getLong(4);
//                System.out.println(firstName + "    " + lastName + "   " + salary + "    " + managerId);
//            }

// 7) Получить имена сотрудников, у которых в имени вторая буква = m,
// а предпоследняя буква = t
//            ResultSet rs = statement.executeQuery("SELECT FIRST_NAME FROM employees ");
//            while (rs.next()){
//                String firstName = rs.getString(1);
//                char [] array = new char[firstName.length()];
//                for(int i= 0; i<array.length; i++){
//                    char symbol = firstName.charAt(i);
//                    array[i] = symbol;
//                }
//                if (array[1]== 'm' && array[array.length-2]== 't'){
//                    System.out.println(firstName);
//                }
//            }
// 8) Получить имя, должность сотрудников, должность которых не входит в список: 'ST_CLERK','IT_PROG','MK_MAN'
//            ResultSet rs = statement.executeQuery(
//                    "SELECT FIRST_NAME, JOB_ID  "+
//                            "FROM employees "+
//                            "WHERE JOB_ID != 'ST_CLERK' AND JOB_ID != 'IT_PROG' AND JOB_ID != 'MK_MAN'");
//            while (rs.next()){
//                String firstName = rs.getString(1);
//                String jobId = rs.getString(2);
//                System.out.println(firstName + "    " + jobId );
//            }
// 9) Получить сотрудников в порядке возрастания дат зачисления на работу
//            ResultSet rs = statement.executeQuery(
//                    "SELECT FIRST_NAME, HIRE_DATE  "+
//                            "FROM employees "+
//                            "ORDER BY HIRE_DATE");
//            while (rs.next()){
//                String firstName = rs.getString(1);
//                String hireDate = rs.getString(2);
//                System.out.println(hireDate + "\t" + "\t" + firstName );
//            }






        } catch (SQLException e) {
            System.out.println("Connection failed");
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            try {
                conn.close(); // закрывает соединение с БД.
            } catch (SQLException e) {
            }
        }
    }






    public static void main(String[] args) {

        try {
            createDbUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
