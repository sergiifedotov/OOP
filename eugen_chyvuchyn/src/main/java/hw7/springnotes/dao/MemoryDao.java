package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;

import java.util.List;

/**
 * Created by Chuvychin on 19.02.2015.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long ig);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List<Memory> findAll();
}
