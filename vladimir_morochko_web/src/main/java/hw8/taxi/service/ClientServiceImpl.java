package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.ArrayList;
import java.util.Date;
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

    private ArrayList<Client> clients;

    public ClientServiceImpl() {
        clients = new ArrayList<>();
    }
    public ClientServiceImpl(ArrayList<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        // TODO existing client
        if (name != null && address != null) {
            Long clientId = clients.size() + 1L;
            Client client = new Client(clientId, name, surname, phone, address);
            clients.add(client);
            System.out.println(client);
            return true;
        } else {
            throw new ClientException();
        }
    }

    @Override
    public List<Client> showClientsByPortion(int portionSize) {
        int clientPortionSize = portionSize > clients.size() ? clients.size() : portionSize;
        return clients.subList(0, clientPortionSize);
    }

    @Override
    public List<Client> showClientsGtSum(int sum) {
        List <Client> list = new ArrayList<>();
        for (Client client : clients) {
            if (client.getSum() > sum) {
                list.add(client);
            }
        }
        return list;
    }

    @Override
    public List<Client> showClientsLastMonth() {
        List <Client> list = new ArrayList<>();
        Date currentDate = new Date();
        Long monthMilliseconds = (long)1000 * 60 * 60 * 24 * 31;
        for (Client client : clients) {
            if (client.getLastOrderDate() != null
                    && (currentDate.getTime() - client.getLastOrderDate().getTime() < monthMilliseconds)) {
                list.add(client);
            }
        }
        return list;
    }
}
