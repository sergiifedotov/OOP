package session13_14;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chuvychin on 21.02.2015.
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    private SessionFactory factory;


    public EmployeeDaoImpl() {
    }

    @Autowired
    public EmployeeDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<Employee> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Employee>)session.createCriteria(Employee.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }
}
