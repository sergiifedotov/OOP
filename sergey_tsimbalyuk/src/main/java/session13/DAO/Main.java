package session13.DAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Locale;

/**
 * Created by tsv on 21.02.15.
 */
public class Main {
    public static void main(String args[]){

        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("../../../resources/session13/context-db.xml");

        CompanyTwoDao JamaicanBoombastic = context.getBean("JamaicanBoombastic", CompanyTwoDao.class);
        CompanyTwoDao Country = context.getBean("Country", CompanyTwoDao.class);

        List<EmployeeTwoDao> list = JamaicanBoombastic.getEmployeeTwoDaoList();
        list.forEach(System.out::println);

        list = Country.getEmployeeTwoDaoList();
        list.forEach(System.out::println);
    }
}
