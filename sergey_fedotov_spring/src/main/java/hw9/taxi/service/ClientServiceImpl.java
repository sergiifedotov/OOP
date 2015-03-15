package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.domain.Client;
import hw9.taxi.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    public ClientServiceImpl() {
    }

    public ClientServiceImpl(ClientDao dao) {
        clientDao = dao;
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        clientDao.create(new Client(name,surname,phone,address));
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getClientsByPortion(int portionSize) {
        return clientDao.getClientsByPortion(portionSize);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getClientsGtSum(int sum) {
        return clientDao.getClientsGtSum(sum);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getClientsLastMonth() {
        return clientDao.getClientsLastMonth();
    }

   /* @Transactional(readOnly = true)
    @Override
    public void showClientsByPortion(int portionSize) {
        return clientDao.getClientsByPortion(portionSize);
    }

    @Transactional(readOnly = true)
    @Override
    public void showClientsGtSum(int sum) {

    }

    @Transactional(readOnly = true)
    @Override
    public void showClientsLastMonth() {

    }*/
}
