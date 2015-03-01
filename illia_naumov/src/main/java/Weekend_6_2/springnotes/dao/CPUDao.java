package Weekend_6_2.springnotes.dao;

import Weekend_6_2.springnotes.domain.CPU;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List<CPU> findAll();
}
