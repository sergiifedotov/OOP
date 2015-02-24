package hw7.springnotes;

import hw7.springnotes.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vladimir on 23.02.2015.
 */
public class Main {
    @Autowired(required = true)
    NotebookService notebookService;

    public static void main(String[] args) {
        Main main = new Main();

        main.notebookService.getNotebooks();
    }
}
