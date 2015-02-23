package session12.companyDao;

import java.util.List;

/**
 * Created by @CAT_Caterpiller on 15.02.2015.
 */

public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);
    boolean update(Employee employee);
    boolean delete(Employee employee);
    List<Employee> findAll();
    List<Employee> findEmployeesByCapital(long capital);

    public void close();
}
