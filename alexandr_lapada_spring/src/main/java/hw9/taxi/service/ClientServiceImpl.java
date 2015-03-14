package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sanya on 11.03.2015.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        clientDao.create(new Client(name, surname, phone, address));
        return true;
    }

    @Override
    public void showClientsByPortion(int portionSize) {
        ArrayList<Client> listClients = (ArrayList<Client>) clientDao.findAll();
        for (int i = 0; i < listClients.size(); i++){
            System.out.println(listClients.get(i));
        }
    }

    @Override
    public void showClientsGtSum(int sum) {

    }

    @Override
    public void showClientsLastMonth() {

    }

    @Override
    public Long create(Client client) {
        return (long)clientDao.create(client);
    }

    @Override
    public Client read(Long id) {
        return clientDao.read(id);
    }

    @Override
    public boolean update(Client client) {
        clientDao.update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        clientDao.delete(client);
        return true;
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public List<Client> findAllByPortion(int first, int result) {
        return clientDao.findAllByPortion(first, result);
    }

    @Override
    public List<Client> findAllGtSumm(Double sum) {
        return clientDao.findAllGtSumm(sum);
    }

    @Override
    public List<Client> findAllLastMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date toDay = null;
        Date dayBeforeMonth = null;
        try {
            toDay = dateFormat.parse(dateFormat.format(new Date()));
            dayBeforeMonth = dateFormat.parse("12-02-2015");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return clientDao.findAllLastMonth(toDay, dayBeforeMonth);
    }
}
