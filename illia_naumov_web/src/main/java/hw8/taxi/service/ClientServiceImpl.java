package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by illia_naumov on 10.03.2015.
 */
public class ClientServiceImpl implements ClientService {
    private List<Client>  clients;
    public ClientServiceImpl() {
        clients = new ArrayList<Client>();
        clients.add(new Client("Anton", "Antonov", "9999", "Antonova 33"));
        clients.add(new Client("2", "2", "2", "2"));
        clients.add(new Client("3", "3", "3", "3"));
        clients.add(new Client("4", "4", "4", "4"));
        clients.add(new Client("5", "5", "5", "5"));
        clients.add(new Client("6", "6", "6", "6"));
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        Client client = new Client(name, surname, phone, address);
        clients.add(client);
        return true;
    }

    @Override
    public List<Client> showClientsByPortion(int portionSize) {
        List<Client>  clientsByPortion = new ArrayList<Client>();

        for(int i = 0; i < portionSize; i++){
            clientsByPortion.add(clients.get(i));
        }
        return clientsByPortion;
    }

    @Override
    public List<Client> showClientsGtSum(int sum) {
        return null;
    }

    @Override
    public List<Client> showClientsLastMonth() {
        return null;
    }
}
