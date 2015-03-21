package session11.company.view;

import org.hibernate.SessionFactory;
import session11.company.dao.CompanyDao;
import session11.company.dao.CompanyDaoImpl;
import session11.company.dao.EmployeeDao;
import session11.company.dao.EmployeeDaoImpl;
import session11.company.domain.Company;
import session11.company.domain.Employee;
import session11.company.service.CompanyService;
import session11.company.service.CompanyServiceImpl;
import session11.company.service.EmployeeService;
import session11.company.service.EmployeeServiceImpl;
import session11.company.util.HibernateUtil;

import java.util.List;


/**
 *
 */
public class Menu {

    public static void main(String[] args) {

        CompanyDao companyDao = new CompanyDaoImpl();
        CompanyService companyService = new CompanyServiceImpl(companyDao);

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);

       /* Company company1 = new Company("Company1", 4000.00);
        Company company2 = new Company("Company2", 8000.00);

        companyService.add(company1);
        companyService.add(company2);

        for(int i=1;i<=100;i++){
            Employee employee = new Employee("Employee1"+i,1.00*i);
            company1.hireEmployee(employee);
            employeeService.add(employee);
            employee = new Employee("Employee2"+i,1.00*i);
            company2.hireEmployee(employee);
            employeeService.add(employee);
        }*/

        //System.out.println(companyService.findAll().toString());
        List<Company> list = companyService.findAll();
        //System.out.println(employeeService.findAll().toString());

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            sessionFactory.close();
        }

    }


}
