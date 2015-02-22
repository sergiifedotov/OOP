package session13.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import session13.EmployeeDao;
import session13.EmployeeDaoImpl;

/**
 * Created by illia_naumov on 22.02.2015.
 */

@Service("serv")
public class ServiceDaoImpl implements ServiceDao{
    @Autowired
    EmployeeDao dao;
    public ServiceDaoImpl() {
    }
    public void readAll(){
        dao.findAll();
    }
}
