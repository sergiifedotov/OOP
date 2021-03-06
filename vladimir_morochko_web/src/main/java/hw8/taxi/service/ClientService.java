package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 03.03.2015.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws ClientException;
    List<Client> showClientsByPortion(int portionSize);
    List<Client> showClientsGtSum(int sum);
    List<Client> showClientsLastMonth();

    ArrayList<Client> getClients();
    void setClients(ArrayList<Client> clients);
    Client getClientById(Long id);
}
