package Weekend_7_2;

import Weekend_7_2.Region;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanya on 22.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Weekend_7_2/context.xml");
        SessionFactory factory = (SessionFactory) context.getBean("sf");
       /*( Man man = (Man) context.getBean("man");
        Car car = (Car) context.getBean("car");
        Company company = (Company) context.getBean("company");
        System.out.println(man);
        System.out.println(car);
        System.out.println(company);

        SessionFactory factory = (SessionFactory) context.getBean("sf");
        RegionDao regionDao = (RegionDao) context.getBean("regionDaoImpl");
        List<Region> list = (ArrayList<Region>)regionDao.findAll();
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        */

        Menu menu = (Menu) context.getBean("menu");
        menu.main();
        factory.close();
    }
}
