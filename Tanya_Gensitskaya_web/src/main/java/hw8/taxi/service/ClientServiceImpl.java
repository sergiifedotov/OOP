package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.List;

/**
 * Created by Tanya on 05.03.2015.
 */
public class ClientServiceImpl implements ClientService {


    // метод проверяет корректность ввода имени, фамилии, телефона и адреса
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        return true;    }

    @Override
    public List<Client> showClientsByPortion(int portionSize) {
        return null;
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
