package hw7.springnotes;

import hw7.springnotes.service.NotebookService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;


import java.util.Locale;

/**
 * Created by vladimir on 23.02.2015.
 */

public class Main {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hw7/springnotes/transactionalContext.xml");

    private NotebookService notebookService = applicationContext.getBean("notebookServiceImpl", NotebookService.class);


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Main main = new Main();

        System.err.println(main.notebookService.getNotebooks());

        main.notebookService.close();
    }
}
