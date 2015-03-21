package hw8.taxi.dao;

import hw8.taxi.domain.User;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface OperatorDao {
    Long create(User operator);
    User read(Long id);
    boolean update(User operator);
    boolean delete(User operator);
    List findAll();

    User getOperatorByLogin(String login);
}
