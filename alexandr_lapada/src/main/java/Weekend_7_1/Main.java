package Weekend_7_1;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanya on 21.02.2015.
 */
public class Main {



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Weekend_7_1/context.xml");
/*
        Man direktor = context.getBean("direktorBean", Man.class);
        Company company = context.getBean("companyBean", Company.class);
        Car car = context.getBean("carBean", Car.class);

        System.out.println(direktor);
        System.out.println(car);
        System.out.println(company);
*/
        RegionDaoImpl regionDao = (RegionDaoImpl) context.getBean("RegionDao");
        List<Region> list = (ArrayList <Region>)regionDao.findAll();
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
