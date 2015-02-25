package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */

public interface CPUDao {

    Long create(CPU cpu);

    CPU read(Long id);

    boolean update(CPU cpu);

    boolean delete(CPU cpu);

    List<CPU> findAll();

}
