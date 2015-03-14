package hw9.taxi.dao;

import hw9.taxi.domain.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sanya on 11.03.2015.
 */
@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    @Autowired
    SessionFactory factory;

    @Override
    public Long create(Client client) {
        Session session = factory.getCurrentSession();
        return (long)session.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client read(Long id) {
        Session session = factory.getCurrentSession();
        return (Client) session.get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        Session session = factory.getCurrentSession();
        session.update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        Session session = factory.getCurrentSession();
        session.delete(client);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Client.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAllByPortion(int first, int result) {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Client.class).setFirstResult(first).setMaxResults(result).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAllGtSumm(Double sum) {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Client.class).add(Restrictions.gt("summa",sum)).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAllLastMonth(Date toDay, Date dayBeforeMonth) {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Client.class).add(Restrictions.gt("dateLastOrder",dayBeforeMonth)).add(Restrictions.lt("dateLastOrder",toDay)).list();
    }
}
