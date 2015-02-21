package session11_12;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chuvychin on 15.02.2015.
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(factory);

//        Session session = factory.openSession();
//        session.beginTransaction();
////
//          Company asus = new Company();
//        Company apple = new Company();
//       asus.setName("ABRACADABRA");
//       apple.setName("HELL_AND_PARADICE");
//       asus.setCharterCapital(500000.00);
//        apple.setCharterCapital(1000000.00);
//
//        Employee person1 = new Employee();
//        Employee person2 = new Employee();
//        Employee person3 = new Employee();
//        Employee person4 = new Employee();
//        Employee person5 = new Employee();
//
//        person1.setName("Jon");
//        person1.setProf("project_manager");
//        person2.setName("Lara");
//        person2.setProf("affilate_manager");
//        person3.setName("Gerold");
//        person3.setProf("developer");
//        person4.setName("Ivan");
//        person4.setProf("manager");
//        person5.setProf("sales");
//        person5.setName("Pol");
//        person1.setAge(27);
//        person2.setAge(25);
//        person3.setAge(30);
//        person4.setAge(31);
//        person5.setAge(28);
//
//        Set<Employee> asusE = new HashSet<>();
//        Set<Employee> appleE = new HashSet<>();
//
//        person1.setWork(asus);
//        person2.setWork(asus);
//        person3.setWork(asus);
//        person4.setWork(apple);
//        person5.setWork(apple);
//
//        asusE.add(person1);
//        asusE.add(person2);
//        asusE.add(person3);
//        appleE.add(person4);
//        appleE.add(person5);
//        asus.setEmployers(asusE);
//        apple.setEmployers(appleE);
//
//
//        session.save(asus);
//        session.save(apple);
//
//
//       session.getTransaction().commit();


//        Company company = (Company) session.get(Company.class, (long)39);
//        Employee empl = (Employee) session.get(Employee.class, (long) 25);
//        session.delete(empl);
//        session.getTransaction().commit();


//        session.close();

        List<Employee> employees = employeeDao.findEmployeesByAgeInCompany("ABRACADABRA",27);

//        Iterator iterator = employees.iterator();
       System.out.println(employees.size());
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(Employee e: employees){
            System.out.println(e.getId()+" / "+e.getName()+" / "+e.getAge()+" / "+ e.getProf()+" / "+e.getWork().getName()+" / "+e.getWork().getCharterCapital());
        }
        factory.close();

        //for (Employee e: company.getEmployers()){
        //   System.out.println(e);
        //}

    }
}
