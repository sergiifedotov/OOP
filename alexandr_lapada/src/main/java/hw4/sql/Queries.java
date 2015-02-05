package hw4.sql;


import java.sql.*;

/**
 С помощью язка запросов SQL написать следующие запросы:

 1) Получить одну колонку из таблицы employees
 2) Получить одну колонку из таблицы employees без дубликатов
 3) Получить налог в 10% с зарплаты сотрудников за месяц
 4) Получить имена сотрудников, работающих с 01.01.1982
 5) Получить имена сотрудников с зарплатой, меньшей, чем комиссионные
 6) Получить имена сотрудников с зарплатой и кодом руководителя,
 для которых этот код принимает одно из значений 114, 121, 205
 7) Получить имена сотрудников, у которых в имени вторая буква = m,
 а предпоследняя буква = t
 8) Получить имя, должность сотрудников, должность которых не входит в список: 'ST_CLERK','IT_PROG','MK_MAN'
 9) Получить сотрудников в порядке возрастания дат зачисления на работу

 Запросы оформить в виде комментариев в классе hw4.sql.Queries
 */
public class Queries {
    public static void main(String[] args) {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        try {
            Connection connection = DriverManager.getConnection(url, "hr", "hr");
            Statement stat = connection.createStatement();
            //1 - ResultSet rs = stat.executeQuery("SELECT first_name FROM employees ");
            //2 - ResultSet rs = stat.executeQuery("SELECT DISTINCT first_name FROM employees ");
            /*3 - ResultSet rs = stat.executeQuery("SELECT salary FROM employees");
            Double sum = 0.0;
            while (rs.next()) {
                Double salary = rs.getDouble(1);
                sum += salary;
                System.out.println("first_name :" + salary);
            }
            System.out.println(sum*0.1);*/
            //4 - ResultSet rs = stat.executeQuery("SELECT first_name FROM employees WHERE hire_date >= '01.JAN.1982' ");
            //5 - ResultSet rs = stat.executeQuery("SELECT salary FROM employees WHERE salary < commission_pct");
            //6 - ResultSet rs = stat.executeQuery("SELECT first_name, salary, manager_id FROM employees WHERE manager_id = 114 OR  manager_id = 121 OR  manager_id = 205");
            //7 - ResultSet rs = stat.executeQuery("SELECT first_name FROM employees WHERE first_name LIKE '_m%t_'");
            //8 - ResultSet rs = stat.executeQuery("SELECT first_name, job_id FROM employees WHERE job_id != 'ST_CLERK' AND job_id != 'IT_PROG' AND job_id != 'MK_MAN'");
            //9 - ResultSet rs = stat.executeQuery("SELECT * FROM employees ORDER BY hire_date");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
