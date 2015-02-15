package Weekend_6_2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 15.02.2015.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }
    @Override
    public List<Employee> selectEmplFondGT(Double fond) {
        Session session = null;
        try{
            session = factory.openSession();
        } catch(HibernateException e){

        }
        return null;
    }
}
