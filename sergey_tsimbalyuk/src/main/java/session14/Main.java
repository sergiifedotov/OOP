package session14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tsv on 22.02.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:session14/context.xml");
        Company company = context.getBean(Company.class);

        System.out.println(company);
    }
}