package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tsv on 21.02.15.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/fContext.xml");
        Car car = context.getBean("car", Car.class);
        Human human = context.getBean("human", Human.class);

        System.out.println(car);
        System.out.println(human);

    }
}
