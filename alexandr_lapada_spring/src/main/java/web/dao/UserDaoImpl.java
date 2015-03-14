package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.domain.User;

import java.util.List;

/**
 * Created by sanya on 07.03.2015.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        Session session = factory.getCurrentSession();
        List<User> list = session.createCriteria(User.class).list();
        return list;
    }
}
