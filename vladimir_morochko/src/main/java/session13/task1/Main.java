package session13.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by vladimir on 22.02.2015.
 */
public class Main {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("session13/task1/context.xml");
    Car car = applicationContext.getBean("car", Car.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); // не забывать про локаль!
        Main main = new Main();

        System.out.println(main.car);
    }

}
