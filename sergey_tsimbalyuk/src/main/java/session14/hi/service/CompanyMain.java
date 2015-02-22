package session14.hi.service;

import org.springframework.context.ApplicationContext;
import session14.hi.dao.CompanyDao;
import session14.hi.dao.EmployeeDao;
import session14.hi.domain.Company;
import session14.hi.domain.Employee;

public class CompanyMain {
    public static void main(String[] args) {
        ApplicationContext context = new org.springframework.context.support.ClassPathXmlApplicationContext("classpath:session14/hibContext.xml");
        EmployeeDao employeeDao = context.getBean("employeeDaoImpl", EmployeeDao.class);
        CompanyDao companyDao = context.getBean("companyDaoImpl", CompanyDao.class);

        System.out.println(companyDao);
        System.out.println(employeeDao);

//        Company cmp1 = new Company("Oval");
//        Company cmp2 = new Company("Square");

        /*
        companyDao.create(cmp1);
        companyDao.create(cmp2);

        Employee man1 = new Employee("JamieOlliver", cmp1);
        employeeDao.create(man1);
        Employee man2 = new Employee("JonQ", cmp1);
        employeeDao.create(man2);
        Employee man3 = new Employee("AndrewStanfield", cmp2);
        employeeDao.create(man3);
        Employee man4 = new Employee("Fonzie", cmp2);
        employeeDao.create(man4);*/
/*
        CompanyService companyService = context.getBean("companyService", CompanyService.class);
        companyService.toEmploy(cmp1, man1);
        companyService.toEmploy(cmp1, man2);
        companyService.toEmploy(cmp2, man3);
        companyService.toEmploy(cmp2, man4);*/

        /*
          public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/hibContext.xml");

        SessionFactory factory = (SessionFactory) context.getBean("sf");
        Session session = factory.openSession();

        session.beginTransaction();

    }
         */

    }
}
