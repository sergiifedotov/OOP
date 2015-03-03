package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.List;

/**
 * Created by vladimir on 03.03.2015.
 *
 *  Функции:
 - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 - вывести всех клиентов порциями по 10 человек
 - вывести всех клиентов наездивших на сумму больше указанной
 - вывести всех клиентов, делавших заказы за последний месяц

 hw8.taxi.service.ClientService
 boolean createClient(String name, String surname, String phone, String address) throws ClientException
 List<Client> showClientsByPortion(int portionSize)
 List<Client> showClientsGtSum(int sum)
 List<Client> showClientsLastMonth()
 */
public class ClientServiceImpl implements ClientService {
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        return false;
    }

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
