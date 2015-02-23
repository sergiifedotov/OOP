package Weekend_7_1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 21.02.2015.
 */
public class RegionDaoImpl {
    SessionFactory factory;

    public RegionDaoImpl(){

    }

    public RegionDaoImpl(SessionFactory factory){
        this.factory = factory;
        
    }

    public List<Region> findAll(){
        Session session = null;
        List<Region> list = null;
        try{
            session = factory.openSession();
            list = session.createCriteria(Region.class).list();
        } catch (HibernateException e){
            e.getMessage();
            System.err.println("***********");
        } finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}
