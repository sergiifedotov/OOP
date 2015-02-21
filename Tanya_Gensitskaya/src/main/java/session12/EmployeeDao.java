package session12;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public interface EmployeeDao {

    Employee read(String capital);
    Long create(Employee empl);
    Employee read(Long empl);

}
