package hw9.taxi.dao;

import hw9.taxi.domain.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public ClientDaoImpl() {
    }

    @Override
    public Long create(Client client) {
        return (Long) sessionFactory.getCurrentSession().save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client read(Long id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        sessionFactory.getCurrentSession().update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Client.class);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List getClientsByPortion(int portionSize) {
        int firstResult = 0;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Client.class)
                .setFirstResult(firstResult)
                .setMaxResults(portionSize);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List getClientsGtSum(int sum) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Client.class)
                .add(Restrictions.gt("sum", sum));
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List getClientsLastMonth() {
        Date monthAgo = new Date();
        Long monthMilliseconds = 1000L * 60 * 60 * 24 * 31;
        monthAgo.setTime(monthAgo.getTime() - monthMilliseconds);
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Client.class)
                .add(Restrictions.gt("lastOrderDate", monthAgo));
        return criteria.list();
    }
}
