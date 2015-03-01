package Weekend_6_2.springnotes.dao;

import Weekend_6_2.springnotes.domain.Memory;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List<Memory> findAll();
}
