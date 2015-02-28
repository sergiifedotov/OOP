package session13_14;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Chuvychin on 21.02.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13_14/context.xml");
//        Man man1 = context.getBean("man1", Man.class);
//        Man man2 = context.getBean("man2", Man.class);



//        EmployeeDao employeeDao = context.getBean("employeeDaoImpl", EmployeeDao.class);
//
//        List<Employee> list = employeeDao.findAll();
//
//        for (Employee e:list){
//            System.out.println(e);
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. findAll");

            int a = Integer.parseInt(br.readLine());

            switch (a){
                case 1: EmployeeService employeeService = context.getBean("employeeServiceImpl", EmployeeService.class);
                    List<Employee> list = employeeService.findAll();
                    for (Employee e:list){
                        System.out.println(e);
                    }
            }


        br.close();

    }
}
