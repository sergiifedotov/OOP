package session14.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by warit on 21.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/task1/context.xml");

        Man man1 = context.getBean("man1", Man.class);
        Car car1 = context.getBean("car1", Car.class);
        Company company1 = context.getBean("company1", Company.class);

        System.out.println(company1);
    }

}
