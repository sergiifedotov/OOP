package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.domain.Client;
import hw9.taxi.exception.ClientException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired(required = true)
    private ClientDao clientDao;

    public ClientServiceImpl() {
    }

    @Override
    public Long createClient(String name, String surname, String phone, String address) throws ClientException {
        if (name != null && address != null) {
            Client client = new Client(name, surname, phone, address);
            Long clientId = clientDao.create(client);
            return clientId;
        } else {
            throw new ClientException("Заполните имя и фамилию клиента");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List getClientsByPortion(int portionSize) {
        return clientDao.getClientsByPortion(portionSize);
    }

    @Override
    @Transactional(readOnly = true)
    public List getClientsGtSum(int sum) {
        return clientDao.getClientsGtSum(sum);
    }

    @Override
    @Transactional(readOnly = true)
    public List getClientsLastMonth() {
        return clientDao.getClientsLastMonth();
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return clientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClient(Long clientId) {
        return clientDao.read(clientId);
    }
}
