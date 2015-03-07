package session13;


import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by stan on 21.02.15.
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
