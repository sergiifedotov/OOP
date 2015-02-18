package hw6.notes.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Locale;

/**
 * Created by illia_naumov
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static{
        try{
            Locale.setDefault(Locale.ENGLISH);
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
