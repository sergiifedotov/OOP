package session13.dao;

import session13.domain.Employee;

import java.util.List;

/**
 * Created by ZaR on 22.02.15.
 */
public interface EmployeeDao {

    public void create(Employee empl);
    public Employee read(Long empl);
    public List<Employee> findAll();

}
