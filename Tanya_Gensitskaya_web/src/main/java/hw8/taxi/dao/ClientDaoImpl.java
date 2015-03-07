package hw8.taxi.dao;

import hw8.taxi.domain.Client;
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
public class ClientDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(OperatorDaoImpl.class);
    private SessionFactory factory = new HibernateUtil().buildSessionFactory();

    public ClientDaoImpl() {
    }

    @Override
    public Long create(Client client) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(client);
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
    public Client read(Long id) {
        return null;
    }

    @Override
    public boolean update(Client client) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(client);
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
    public boolean delete(Client client) {
        return false;
    }

    @Override
    public List<Client> findAll() {
        List<Client> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list = session.createCriteria(Client.class).list();
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
