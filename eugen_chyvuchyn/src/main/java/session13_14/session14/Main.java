package session13_14.session14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Chuvychin on 22.02.2015.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13_14/context.xml");

        Company company = context.getBean("company", Company.class);

        System.out.println(company);
    }
}
