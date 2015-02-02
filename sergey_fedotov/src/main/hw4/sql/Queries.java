package sql;


    /**
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

        //1) Получить одну колонку из таблицы employees
    /*
    SELECT first_name FROM employees;
    */

        //2) Получить одну колонку из таблицы employees без дубликатов
    /*
    SELECT DISTINCT job_id FROM employees;
     */

        //3) Получить налог в 10% с зарплаты сотрудников за месяц
    /*
    SELECT salary * .1 tax FROM employees;
     */

        //4) Получить имена сотрудников, работающих с 01.01.1982
    /*
    SELECT first_name,last_name FROM employees WHERE hire_date = to_date('01.01.1982', 'dd.mm.yyyy');
     */

        //5) Получить имена сотрудников с зарплатой, меньшей, чем комиссионные
    /*
    SELECT first_name,last_name FROM employees WHERE salary < commission_pct;
     */

        //6) Получить имена сотрудников с зарплатой и кодом руководителя,
        //для которых этот код принимает одно из значений 114, 121, 205
    /*
    SELECT first_name,last_name,salary,manager_id FROM employees WHERE manager_id in (114, 121, 205);
     */

        //7) Получить имена сотрудников, у которых в имени вторая буква = m,
        //а предпоследняя буква = t
    /*
    SELECT first_name FROM employees WHERE first_name like '_m%t_';
     */

        //8) Получить имя, должность сотрудников, должность которых не входит в список: 'ST_CLERK','IT_PROG','MK_MAN'
    /*
    SELECT first_name,last_name,job_id FROM employees WHERE job_id not in ('ST_CLERK','IT_PROG','MK_MAN');
     */

        //9) Получить сотрудников в порядке возрастания дат зачисления на работу
    /*
    SELECT * FROM employees order by hire_date;
     */
    }

