package session13.task2;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

/**
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
    private SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Employee> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            return (List) session.createCriteria(Employee.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return null;

    }



}
