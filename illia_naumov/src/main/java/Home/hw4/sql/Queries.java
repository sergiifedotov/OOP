package Home.hw4.sql;

/**
 * Created by illia_naumov on 02.02.2015.
 *
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

 Запросы оформить в виде комментариев в классе hw4.sql.Queries
 */
public class Queries {
    // 1)SELECT last_name FROM employees
    // 2)SELECT DISTINCT first_name FROM employees
    // 3)SELECT DISTINCT first_name FROM employees
    // 4)SELECT first_name, last_name, hire_date FROM employees WHERE hire_date > '01.JAN.82'
    // 5)SELECT first_name FROM employees WHERE salary > commission_pct
    // 6)SELECT first_name, manager_id FROM employees WHERE manager_id = '114' OR manager_id = '121' OR manager_id = '205'
    // 7)SELECT first_name FROM employees WHERE first_name LIKE '_m%t_'
    // 8)SELECT first_name, job_id FROM employees WHERE job_id != 'it_prog' AND job_id != 'st_clerk' AND job_id != 'mk_man'
    // 9)SELECT first_name, hire_date FROM employees ORDER BY hire_date ASC
    //

}
