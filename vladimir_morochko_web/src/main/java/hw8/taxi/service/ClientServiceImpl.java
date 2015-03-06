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

    public static ClientService clientService = new ClientServiceImpl();

    private ArrayList<Client> clients = new ArrayList<>();

    public ClientServiceImpl() {
        Client client = new Client("Ваня", "Иванов", "1234567890", "ул. Бассейная, 1");
        client.setLastOrderDate(new Date());
        client.setSum(123);
        Long clientId = clients.size() + 1L;
        client.setId(clientId);
        clients.add(client);
        client = new Client("Петя", "Петров", "2345678901", "ул. Бассейная, 2");
        client.setLastOrderDate(new Date());
        client.setSum(234);
        clientId = clients.size() + 1L;
        client.setId(clientId);
        clients.add(client);
        client = new Client("Сидор", "Сидоров", "3456789012", "ул. Бассейная, 3");
        client.setLastOrderDate(new Date());
        client.setSum(345);
        clientId = clients.size() + 1L;
        client.setId(clientId);
        clients.add(client);
        client = new Client("Прошка", "Прохоров", "4567890123", "ул. Бассейная, 4");
        client.setLastOrderDate(new Date());
        client.setSum(456);
        clientId = clients.size() + 1L;
        client.setId(clientId);
        clients.add(client);
        client = new Client("Изя", "Зильберштуцер", "5678901234", "ул. Бассейная, 5");
        client.setLastOrderDate(new Date());
        client.setSum(567);
        clientId = clients.size() + 1L;
        client.setId(clientId);
        clients.add(client);
        client = new Client("Махмуд", "Алинбеков", "6789012345", "ул. Бассейная, 6");
        client.setLastOrderDate(new Date());
        client.setSum(678);
        clientId = clients.size() + 1L;
        client.setId(clientId);
        clients.add(client);
    }

    public ClientServiceImpl(ArrayList<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        if (name != null && address != null) {
            Long id = clients.size() + 1L;
            Client client = new Client(id, name, surname, phone, address);
            return clients.add(client);
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
            if (client.getSum() != null && client.getSum() > sum) {
                list.add(client);
            }
        }
        return list;
    }

    @Override
    public List<Client> showClientsLastMonth() {
        List <Client> list = new ArrayList<>();
        Date currentDate = new Date();
        Long monthMilliseconds = 1000L * 60 * 60 * 24 * 31;
        for (Client client : clients) {
            if (client.getLastOrderDate() != null
                    && (currentDate.getTime() - client.getLastOrderDate().getTime() < monthMilliseconds)) {
                list.add(client);
            }
        }
        return list;
    }

    @Override
    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    @Override
    public Client getClientById(Long id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
