package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsv on 09.02.15.
 */
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(ntb);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ntb.getId();
    }

    @Override
    public Notebook read(Long ig) {

        Session session = null;
        Notebook notebook = new Notebook();
        try {

            session = factory.openSession();
            session.beginTransaction();
            notebook = (Notebook) session.get(Notebook.class, ig);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return notebook;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = null;

        try {

            session = factory.openSession();
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {

            if (session != null) {
                session.close();

            }

        }

        return true;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = null;
        try {

            session = factory.openSession();

            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {

            if (session != null) {
                session.close();
            }

        }
        return true;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = null;
        List list = new ArrayList<>();
        try {

            session = factory.openSession();

            session.beginTransaction();
            list = session.createCriteria(Notebook.class).list();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return list;
    }

/*    @Override
    public List<Notebook> findByModel(String model) {
        Session session = null;
        List list = new ArrayList<Notebook>();
        try {

            session = factory.openSession();

            session.beginTransaction();
            list = session.createCriteria(Notebook.class).add(Restrictions.eq("model", model)).list();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {

            if (session != null) {
                session.close();
            }

        }

        return list;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = null;
        List list = new ArrayList<>();
        try {

            session = factory.openSession();

            session.beginTransaction();
            list = session.createCriteria(Notebook.class).add(Restrictions.eq("vendor", vendor)).list();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return list;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = null;
        List list = new ArrayList<Notebook>();
        try {

            session = factory.openSession();

            session.beginTransaction();
            list = session.createCriteria(Notebook.class).
                    add(Restrictions.eq("price", price)).add(Restrictions.eq("manufactDate", date)).list();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return list;
    }

    @Override//Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = null;
        List list = null;
        try {

            session = factory.openSession();

            session.beginTransaction();

            list = factory.openSession().createCriteria(Notebook.class)
                    .add(Restrictions.between("price", priceFrom, priceTo))
                    .add(Restrictions.lt("manufactDate", date))
                    .add(Restrictions.like("vendor", vendor)).list();


            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return list;
    }

    @Override
    public boolean deleteByModel(String model) {
        Session session = null;

        List<Notebook> list = findByModel(model);


        try {

            session = factory.openSession();

            session.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                session.delete(list.get(i));
            }
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return true;


    }*/
}