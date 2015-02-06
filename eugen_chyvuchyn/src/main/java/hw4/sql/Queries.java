package hw4.sql;

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

    //1) SELECT hire_date FROM employees;
    //2) SELECT salary FROM employees GROUP BY salary; SELECT DISTINCT first_name from EMPLOYEES;
    //3) SELECT salary*0.1 from employees;
    //4) SELECT first_name, last_name, hire_date FROM employees WHERE hire_date > '01.01.1982';
    //5) SELECT first_name FROM employees WHERE salary < commission_pct;
    //
    //6) select first_name, last_name, salary, manager_id from employees where manager_id = 114 or MANAGER_ID=121 or MANAGER_ID = 205;
    //7) select first_name from EMPLOYEES WHERE FIRST_NAME like '_m%t_'
    //8) select first_name, job_id from EMPLOYEES WHERE job_id not in ('ST_CLERK','IT_PROG','MK_MAN');
    //9)) select first_name, last_name, hire_date from EMPLOYEES ORDER BY HIRE_DATE ASC;


}
