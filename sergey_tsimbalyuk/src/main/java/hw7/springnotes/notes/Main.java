package hw7.springnotes.notes;

import hw7.springnotes.domain.Notebook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:session14/hibContext.xml");
        Notebook notebook = context.getBean(Notebook.class);
        System.out.println(notebook);
    }

}
