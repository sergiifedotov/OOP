package hw9.taxi.dao;

import hw9.taxi.domain.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;

    @Override
    public Long create(Client client) {
        return (Long) factory.getCurrentSession().save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getClientsByPortion(int size) {
        Session session = factory.getCurrentSession();

        List list = session.createCriteria(Client.class).setFirstResult(0).setMaxResults(size).list();
        if(list.size()>0){
            return list;
        }

        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getClientsGtSum(int sum) {
        Session session = factory.getCurrentSession();

        List list = session.createCriteria(Client.class).add(Restrictions.eq("sum", sum)).list();

        if(list.size()>0){
            return list;
        }

        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getClientsLastMonth() {
        Session session = factory.getCurrentSession();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayMonth = calendar.getTime();
        List list = session.createCriteria(Client.class).add(Restrictions.gt("lastOrderDate", firstDayMonth)).list();

        if(list.size()>0){
            return list;
        }

        return null;
    }


}
