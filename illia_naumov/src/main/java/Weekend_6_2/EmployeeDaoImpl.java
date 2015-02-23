package Weekend_6_2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
        List<Employee> list = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Employee.class).createCriteria("company").add(Restrictions.gt("fond",fond)).list();
        } catch(HibernateException e){
            System.err.println("Session faild");
        } finally{
            if(session != null){
                session.close();
                factory.close();
            }
        }
        return list;
    }

    @Override
    public List<Employee> selectEmplByAge(String nameCompany, Integer age) {
        Session session = null;
        List<Employee> list = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Employee.class).add(Restrictions.eq("age",age)).createCriteria("company").add(Restrictions.eq("name",nameCompany)).list();
        } catch(HibernateException e){
            System.err.println("Session faild");
        } finally{
            if(session != null){
                session.close();
                factory.close();
            }
        }
        return list;
    }

    @Override
    public List<Employee> getPortion(int firstResult, int maxResult) {
        Session session = factory.openSession();
        try{
            return (session.createCriteria(Employee.class)
                    .setMaxResults(maxResult)
                    .setFirstResult(firstResult)
                    .list());
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public Long rowsCount() {
        Session session = factory.openSession();
        try{
            return (Long) session.createCriteria(Employee.class)
                       .setProjection(Projections.rowCount())
                    .uniqueResult();
        } finally{
            if(session !=null){
                session.close();
            }
        }
    }

}
