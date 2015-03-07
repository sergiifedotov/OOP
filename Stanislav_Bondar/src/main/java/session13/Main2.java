package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by stan on 21.02.15.
 */
public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:session13/companyContext.xml");

        Man director = context.getBean(Man.class);
        Company company = context.getBean(Company.class);
        System.out.println(director);
        System.out.println(company);
    }
}
