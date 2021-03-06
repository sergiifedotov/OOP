package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long ig);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List<CPU> findAll();
}
