package session14.task2;

import java.util.List;

/**
 * Created by vladimir on 22.02.2015.
 */
public interface EmployeeDao {
    public Long create(Employee employee);
    public Employee read(Long id);
    public void update(Employee employee);
    public void delete(Employee employee);
    public List<Employee> findAll();
}
