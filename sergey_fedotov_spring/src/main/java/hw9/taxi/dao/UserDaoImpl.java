package hw9.taxi.dao;

import hw9.taxi.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

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

        List list = session.createCriteria(User.class).add(Restrictions.eq("login", login)).add(Restrictions.eq("pass", pass)).list();

        //return list.size()>0&&(User)list[0]

        if(list.size()>0){
            User user = (User)list.get(0);
            return !user.getLocked();
        }

        return false;
    }

}
