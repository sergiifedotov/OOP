package hw8.taxi.service;


import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.List;

/**
 *
 */
public interface ClientService {

    boolean createClient(String name, String surname, String phone, String address) throws ClientException;
    List<Client> showClientsByPortion(int portionSize);
    List<Client> showClientsGtSum(int sum);
    List<Client> showClientsLastMonth();

}
