package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tsv on 21.02.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/c.xml");

/*
        Car car1 = context.getBean("CarCEO",Car.class);
        Human ceo1=context.getBean("CEO",Human.class);
        Company company = context.getBean("Company",Company.class);

        System.out.println(car1.toString());
        System.out.println(ceo1.toString());
        System.out.println(company.toString());
*/

  /*      Man man1 = context.getBean("man1", Man.class);
        System.out.println(man1);
*/

        Man man1 = context.getBean("man1", Man.class);
        Man man2 = context.getBean("man2", Man.class);

        System.out.println(man1);
        System.out.println(man2);
    }
}
