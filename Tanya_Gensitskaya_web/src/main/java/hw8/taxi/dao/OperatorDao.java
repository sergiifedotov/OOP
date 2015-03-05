package hw8.taxi.dao;

import hw8.taxi.domain.Operator;

import java.util.List;

/**
 * Created by Tanya on 05.03.2015.
 */
public interface OperatorDao {
    public  Long create(Operator operator);
    public Operator read(Long id);
    public boolean update(Operator operator);
    public boolean delete(Operator operator);
    public List<Operator> findAll();
}
