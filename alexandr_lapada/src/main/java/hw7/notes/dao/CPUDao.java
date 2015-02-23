package hw7.notes.dao;

import hw7.notes.CPU;

import java.util.List;

/**
 * Created by sanya on 17.02.2015.
 */
public interface CPUDao {

    Long create(CPU cpu);

    CPU read(Long id);

    boolean update(CPU cpu);

    boolean delete(CPU cpu);

    List<CPU> findAll();

}
