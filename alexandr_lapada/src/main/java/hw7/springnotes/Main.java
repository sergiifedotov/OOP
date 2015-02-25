package hw7.springnotes;

import hw7.springnotes.service.Menu;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by sanya on 24.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7.springnotes./context.xml");
        SessionFactory factory = (SessionFactory)context.getBean("sf");

        Menu menu = (Menu)context.getBean("menu");
        menu.main();

        factory.close();
    }
}
