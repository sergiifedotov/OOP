package session13.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session13.impls.SonyDirector;

/**
 * Created by Admin on 21.02.2015.
 */
public class StartAction {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SonyDirector director = (SonyDirector) context.getBean("director");
        director.lead();
    }
}
