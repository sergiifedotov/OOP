package session13;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by illia_naumov on 15.02.2015.
 */
@Repository("dao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
    private SessionFactory factory;

    public EmployeeDaoImpl(){

    }
    @Autowired
    public EmployeeDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {

            Session session = factory.getCurrentSession();
            return session.createCriteria(Employee.class)
                    .list();

    }
}
