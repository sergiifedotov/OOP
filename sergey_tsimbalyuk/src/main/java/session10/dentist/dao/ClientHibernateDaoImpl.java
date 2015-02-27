package session10.dentist.dao;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.05.13
 */
public class ClientHibernateDaoImpl {

}
//public class ClientHibernateDaoImpl implements ClientDao {
//    private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);
//    private SessionFactory factory;
//
//    public ClientHibernateDaoImpl(SessionFactory factory) {
//        this.factory = factory;
//    }
//
//    @Override
//    public void create(Client user) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            session.save(user);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            log.error("Transaction failed");
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//        }
//    }
//
//    @Override
//    public Client read(Long id) {
//        return null;
//    }
//
//    @Override
//    public void update(Client client) {
//
//    }
//
//    @Override
//    public void deleteNtb(Client client) {
//
//    }
//
//    @Override
//    public List<Client> findAll() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query query = session.createQuery("from Region");
//        return query.list();
//
//    }
//
//    @Override
//    public List<Client> findMonyGT(long amount) {
//        return null;
//    }
//}
