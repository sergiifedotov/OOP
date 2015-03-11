package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.domain.Client;
import hw9.taxi.exception.ClientException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired(required = true)
    private ClientDao clientDao;

    public ClientServiceImpl() {
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        if (name != null && address != null) {
            Client client = new Client(name, surname, phone, address);
            Long id = clientDao.create(client);
            return true;
        } else {
            throw new ClientException("заполните имя и фамилию клиента");
        }
    }

    @Override
    public List getClientsByPortion(int portionSize) {
        return clientDao.getClientsByPortion(portionSize);
    }

    @Override
    public List getClientsGtSum(int sum) {
        return clientDao.getClientsGtSum(sum);
    }

    @Override
    public List getClientsLastMonth() {
        return clientDao.getClientsLastMonth();
    }
}
