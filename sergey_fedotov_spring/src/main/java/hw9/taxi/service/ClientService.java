package hw9.taxi.service;


import hw9.taxi.domain.Client;
import hw9.taxi.exception.ClientException;

import java.util.List;

/**
 *
 */
public interface ClientService {

    boolean createClient(String name, String surname, String phone, String address) throws ClientException;
   /* void showClientsByPortion(int portionSize);
    void showClientsGtSum(int sum);
    void showClientsLastMonth();*/

    List<Client> getClientsByPortion(int portionSize);
    List<Client> getClientsGtSum(int sum);
    List<Client> getClientsLastMonth();

}
