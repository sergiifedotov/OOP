package session13;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by illia_naumov on 22.02.2015.
 */
public class MainCompany {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }
}
