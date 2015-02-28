package session14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session14.dao.EmployeeDao;
import session14.dao.EmployeeDaoImpl;
import session14.domain.Employee;

import java.util.ArrayList;

/**
 * Created by Tanya on 23.02.2015.
 */
public class Main {
    public static void main(String[] args) {
//        В контексте есть три bean, 1-й директор, 2-й машина, 3-й компания.
//        В компании работает директор, который ездит на машине компании.
//        директор сам по себе
//        машина содержит директора
//        компания содержит и машину и директора
//        Вытянуть из контекста компанию с данными о машине , директоре и компании..

//        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context.xml");
//        Company comp = context.getBean("company", Company.class);
//        System.out.println(comp);


//        в файле conf.properties создать ключи с названиями полей всех обьектов
//        и все эти значения подгрузить через bean

//        ApplicationContext context = new ClassPathXmlApplicationContext("session14/contextConf.xml");
//        Company comp = context.getBean("company", Company.class);
//        System.out.println(comp);


//        Создать DAO для сотрудников схемы Hr. Получить всех сотрудников,
//        вывести на экран. Дао необходимо создать через контекст

        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-db.xml");
        EmployeeDao employeeDao = (EmployeeDaoImpl)context.getBean("EmployeeDao");
        ArrayList<Employee> list = (ArrayList<Employee>)employeeDao.findAll();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
