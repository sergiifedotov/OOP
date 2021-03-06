package Weekend_6_2.springnotes.dao;

import Weekend_6_2.springnotes.domain.Notebook;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 20.02.2015.
 */
@Service
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();
}
