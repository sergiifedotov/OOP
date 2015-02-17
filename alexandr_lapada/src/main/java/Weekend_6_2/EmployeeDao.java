package Weekend_6_2;

import java.util.List;

/**
 * Created by sanya on 15.02.2015.
 */
public interface EmployeeDao {
    List<Employee> selectEmplFondGT(Double fond);

    List<Employee> selectEmplByAge(String nameCompany, Integer age);

    List<Employee> getPortion(Integer first, Integer result);

    Long rowCount();
}
