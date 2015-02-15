package session12;


/**
 * Created by vladimir on 14.02.2015.
 */
public class Main {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private CompanyDao companyDao = new CompanyDaoImpl();

    public static void main(String[] args) {
        Main main = new Main();

        Employee employee1 = new Employee("Ваня", (double) 1000);
        Employee employee2 = new Employee("Петя", (double) 1001);
        Employee employee3 = new Employee("Коля", (double) 1002);
        Employee employee4 = new Employee("Изя", (double) 1003);
        Employee employee5 = new Employee("Махмуд", (double) 999);

        Company company1 = new Company("Рога и Копыта");
        Company company2 = new Company("Копыта и Рога");

        company1.setAuthorizedCapital((long) 10000);
        company2.setAuthorizedCapital((long) 11000);

        company1.hireEmployee(employee1);
        company1.hireEmployee(employee2);
        company1.hireEmployee(employee3);
        company2.hireEmployee(employee4);
        company2.hireEmployee(employee5);

        main.companyDao.createCompany(company1);
        main.companyDao.createCompany(company2);

        System.out.println(main.employeeDao.findEmployeesByCapital(10500));

        if(main.companyDao != null) {
            main.companyDao.close();
        }

        if(main.employeeDao != null) {
            main.employeeDao.close();
        }

    }
}
