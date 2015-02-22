package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by tsv on 14.02.15.
 */
class NotebookDaoImpl {

}
//public class NotebookDaoImpl implements NotebookDao, AutoCloseable {
//    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
//    private Session session;
//    private SessionFactory factory;
//
//    public NotebookDaoImpl() {
//        this.factory = getSessionFactory();
//        this.session = factory.openSession();
//    }
//
//    private static final SessionFactory sessionFactory = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
//        try {
//            Locale.setDefault(Locale.ENGLISH);
//            Configuration cfg = new Configuration().configure("hw6/hiberConfig/hibernate.cfg.xml");
//            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
//            sb.applySettings(cfg.getProperties());
//            StandardServiceRegistry standardServiceRegistry = sb.build();
//            return cfg.buildSessionFactory(standardServiceRegistry);
//        }
//        catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static Session openSession() {
//        return sessionFactory.getCurrentSession();
//    }
//
//    @Override
//    public Long create(Notebook ntb){
//        log.info("Method create: beginTransaction");
//        Long id = new Long(-1);
//        session.getTransaction().setTimeout(3);
//        session.beginTransaction();
//        id = (Long) session.save(ntb);
//        session.getTransaction().commit();
//        log.info("Method create: Transaction commit!");
//        return id;
//    }
//    @Override
//    public Notebook read(Long id){
//        log.info("Method read: beginTransaction");
//        Notebook nt  = null;
//        nt = (Notebook) session.createCriteria(Notebook.class).add(Restrictions.eq("id", id)).uniqueResult();
//        log.info("Method create: Transaction commit!");
//        return nt;
//    }
//
//
//    @Override
//    public boolean delete(Notebook ntb){
//        boolean delete = false;
//        log.info("Method delete: beginTransaction");
//        session.getTransaction().setTimeout(3);
//        session.beginTransaction();
//        if(ntb.getId() != null){
//            session.delete(session.createCriteria(Notebook.class).add(Restrictions.eq("id",ntb.getId())).uniqueResult());
//        }else{
//            session.delete(session.createCriteria(Notebook.class).add(Restrictions.eq("serial",ntb.getSerial())).uniqueResult());
//        }
//        session.getTransaction().commit();
//        delete = true;
//        log.info("Method delete: Transaction commit!");
//        return delete;
//    }
//
//    @Override
//    public List findByModel(String model) {
//        return session.createCriteria(Notebook.class).add(Restrictions.eq("model", model)).list();
//    }
//
//    @Override
//    public boolean update(Notebook ntb){
//        boolean changes = false;
//        log.info("Method update: beginTransaction");
//        session.getTransaction().setTimeout(3);
//        session.beginTransaction();
//        session.update(ntb);
//        session.getTransaction().commit();
//        changes = true;
//        log.info("Method update: Transaction commit!");
//        return changes;
//    }
//
//    @Override
//    public List<Notebook> findAll(){
//        log.info("Method findAll: beginTransaction");
//        return session.createCriteria(Notebook.class).list();
//    }
//
//    @Override
//    public List findByVendor(String vendor) {
//        return session.createCriteria(Notebook.class).add(Restrictions.eq("vendor", vendor)).list();
//    }
//
//    @Override
//    public List findByPriceManufDate(Double price, Date date) {
//        return null;
//    }
//
//    @Override
//    public List findByPriceManufDate(Double price, Date date) {
//        return session.createCriteria(Notebook.class).add(Restrictions.eq("price", price)).add(Restrictions.eq("date",date)).list();
//    }
//
//    @Override
//    public List findBetweenPriceLtDateByVendor(Double MinPrice, Double MaxPrice, Date date, String vendor) {
//        return session.createCriteria(Notebook.class).add(Restrictions.between("price", MinPrice,MaxPrice)).add(Restrictions.eq("date",date)).add(Restrictions.eq("vendor",vendor )).list();
//    }
//
//
//    @Override
//    public void close() throws Exception {
//        session.close();
//        factory.close();
//        log.info("Method close: connection closed!");
//    }
//
//
//}