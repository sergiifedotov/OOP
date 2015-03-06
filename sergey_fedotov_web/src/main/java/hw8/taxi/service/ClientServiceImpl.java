package hw8.taxi.service;


import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ClientServiceImpl implements ClientService {

    private Map<Integer,Client> clientMap = new HashMap<>();

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {

        Client client = new Client(name, surname, phone, address);
        Integer hashCode = client.hashCode();

        Client temp = clientMap.get(hashCode);
        if(temp!=null){
            return false;
        }
        clientMap.put(hashCode, client);

        return true;
    }

    @Override
    public List<Client> showClientsByPortion(int portionSize) {
        return (List) clientMap.values();
    }

    @Override
    public List<Client> showClientsGtSum(int sum) {
        return (List) clientMap.values();
    }

    @Override
    public List<Client> showClientsLastMonth() {
        return (List) clientMap.values();
    }
}
