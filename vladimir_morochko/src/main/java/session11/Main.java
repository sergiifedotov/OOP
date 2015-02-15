package session11;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * Created by vladimir on 14.02.2015.
 */
public class Main {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        Main main = new Main();
        Employee employee1 = new Employee("Ваня", (double) 1000);
        Employee employee2 = new Employee("Петя", (double) 1001);
        Employee employee3 = new Employee("Коля", (double) 1002);
        Employee employee4 = new Employee("Изя", (double) 1003);
        Employee employee5 = new Employee("Махмуд", (double) 999);

        Company company1 = new Company("Рога и Копыта");
        Company company2 = new Company("Копыта и Рога");

        company1.hireEmployee(employee1);
        company1.hireEmployee(employee2);
        company1.hireEmployee(employee3);
        company2.hireEmployee(employee4);
        company2.hireEmployee(employee5);

        Session session = null;
        try {
            session = main.sessionFactory.openSession();
            session.beginTransaction();
            Long id;
//            id = (Long)session.save(company1);
//            id = (Long)session.save(company2);
//            id = (Long)session.save(employee1);
//            id = (Long)session.save(employee2);
//            id = (Long)session.save(employee3);
//            id = (Long)session.save(employee4);
//            id = (Long)session.save(employee5);
//            session.getTransaction().commit();

//            Criteria criteria = session.createCriteria(Employee.class)
//                    .add(Restrictions.eq("company", company2));
//            System.out.println(criteria.list());

//            Company company = (Company) session.get(Company.class, (long) 3);
//            System.out.println(company.getEmployees());

            id = (Long)session.save(company1);
            id = (Long)session.save(company2);
            session.getTransaction().commit();


        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
                main.sessionFactory.close();
            }
        }

    }
}
