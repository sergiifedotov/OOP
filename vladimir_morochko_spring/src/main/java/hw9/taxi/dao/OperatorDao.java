package hw9.taxi.dao;

import hw9.taxi.domain.Operator;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface OperatorDao {
    Long create(Operator operator);
    Operator read(Long id);
    boolean update(Operator operator);
    boolean delete(Operator operator);
    List findAll();

    Operator getOperatorByLogin(String login);
}
