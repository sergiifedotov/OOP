package session10.dentist.service;



import session10.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.05.13
 */
public interface ClientService {
    List<Client> getAllUsers();
    void addNewUser(Client user);
}
