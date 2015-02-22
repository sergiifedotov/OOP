package Weekend_7_2;

import Weekend_7_2.Region;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 21.02.2015.
 */

@Repository
@Transactional
public class RegionDaoImpl implements RegionDao {

    @Autowired
    SessionFactory fs;

    public RegionDaoImpl(){

    }

    public RegionDaoImpl(SessionFactory factory){
        this.fs = factory;
        
    }
    @Transactional(readOnly = true)
    public List<Region> findAll(){
        Session session = fs.getCurrentSession();
        List<Region> list = session.createCriteria(Region.class).list();
        return list;
    }
}
