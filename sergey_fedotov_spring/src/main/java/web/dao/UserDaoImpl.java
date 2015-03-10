package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.domain.User;

/**
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory factory;

    @Transactional(readOnly = true)
    @Override
    public boolean authenticate(String login, String pass) {
        Session session = factory.getCurrentSession();
        return session.createCriteria(User.class).add(Restrictions.eq("login", login)).add(Restrictions.eq("pass", pass)).list().size()>0;
    }

}
