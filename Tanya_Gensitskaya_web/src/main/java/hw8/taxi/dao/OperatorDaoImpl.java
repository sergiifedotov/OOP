package hw8.taxi.dao;

import hw8.taxi.domain.Operator;
import hw8.taxi.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 05.03.2015.
 */
public class OperatorDaoImpl implements OperatorDao {
    private static Logger log = Logger.getLogger(OperatorDaoImpl.class);
    private SessionFactory factory = new HibernateUtil().buildSessionFactory();

    public OperatorDaoImpl() {
    }

    @Override
    public Long create(Operator operator) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(operator);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Operator read(Long id) {
        Session session = null;
        Operator operator = new Operator();
        try {
            session = factory.openSession();
            session.beginTransaction();
            operator = (Operator)session.get(Operator.class, id);
            session.getTransaction().commit();
            return operator;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return operator;
    }

    @Override
    public boolean update(Operator operator) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(operator);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Operator operator) {
        return false;
    }

    @Override
    public List<Operator> findAll() {
        List<Operator> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Operator.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}
