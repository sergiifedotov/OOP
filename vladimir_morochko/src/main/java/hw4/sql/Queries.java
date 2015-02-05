package hw4.sql;

/**
 * Created by vladimir on 02.02.2015.
 * <p/>
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
    /*
    1) Получить одну колонку из таблицы employees
    SELECT first_name FROM employees

    2) Получить одну колонку из таблицы employees без дубликатов
    SELECT DISTINCT job_id FROM employees

    3) Получить налог в 10% с зарплаты сотрудников за месяц
    SELECT SUM(0.1*salary) FROM employees

    4) Получить имена сотрудников, работающих с 01.01.1982
    SELECT first_name FROM employees WHERE hire_date >= '01-JAN-82'

    5) Получить имена сотрудников с зарплатой, меньшей, чем комиссионные
    SELECT * FROM employees WHERE commission_pct > 0.5

    6) Получить имена сотрудников с зарплатой и кодом руководителя,
    для которых этот код принимает одно из значений 114, 121, 205
    SELECT first_name, salary, manager_id FROM employees WHERE manager_id IN (114, 121, 205)

    7) Получить имена сотрудников, у которых в имени
    вторая буква = m, а предпоследняя буква = t
    SELECT first_name FROM employees WHERE first_name LIKE '_m%t_'

    8) Получить имя, должность сотрудников, должность которых
    не входит в список: 'ST_CLERK','IT_PROG','MK_MAN'
    SELECT first_name, job_id FROM employees WHERE job_id NOT IN ('ST_CLERK','IT_PROG','MK_MAN')

    9) Получить сотрудников в порядке возрастания дат зачисления на работу
    SELECT * FROM employees ORDER BY hire_date

     */
}
