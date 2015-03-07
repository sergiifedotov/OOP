package session11;

/**
 * Created by stan on 15.02.15.
 */
import java.util.List;

public interface EmployeeDao {

    Long create(final Employee employee);

    Employee read(final Long id);

    void update(final Employee employee);

    void delete(final Employee employee);

    List<Employee> findAll();

    List<Employee> findAllPartially(final int startRange, final int range);

    Long rowsCount();

    Long rowCount();

    Employee findByName(final String firstName, final String lastName);

}
