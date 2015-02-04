package hw4.sql;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Chuvychin on 04.02.2015.
 * С помощью язка запросов SQL написать следующие запросы:

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

 */
public class Queries {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection conn = null;


        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select first_name FROM employees");
            while(rs.next()){
                String name = rs.getString(1);
                System.out.println(name);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
