package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by warit on 21.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");

        Man man1 = context.getBean("man1", Man.class);
        Man man2 = context.getBean("man2", Man.class);

        System.out.println(man1);
        System.out.println(man2);
    }

}
