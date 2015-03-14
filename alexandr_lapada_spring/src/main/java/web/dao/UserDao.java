package web.dao;

import web.domain.User;

import java.util.List;

/**
 * Created by sanya on 07.03.2015.
 */
public interface UserDao {

    List<User> findAll();
}
