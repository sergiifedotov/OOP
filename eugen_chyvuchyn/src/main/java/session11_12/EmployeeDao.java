package session11_12;

import java.util.List;

/**
 * Created by Chuvychin on 15.02.2015.
 */
public interface EmployeeDao {
    Integer rowsCount();
    List<Employee> viewPortion(int start, int viewMax);
    List<Employee> findByMoreCharterCapital(double CharterCapital);
    List<Employee> findEmployeesByAgeInCompany(String companyName, Integer age);
}
