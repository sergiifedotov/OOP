package session12;

import java.util.List;


public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);
    boolean update(Employee employee);
    boolean delete(Employee employee);
    List<Employee> findAll();
    List<Employee> findEmployeesByCapital(Long capital);
    List<Employee> findEmployeesByCompanyAndAge(String companyName, Integer age);

    public void close();
}
