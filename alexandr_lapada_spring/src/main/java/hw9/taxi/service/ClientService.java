package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

import java.text.ParseException;
import java.util.List;

/**
 * Created by sanya on 11.03.2015.
 */
public interface ClientService {

    boolean createClient(String name, String surname, String phone, String address) throws OrderException;

    void showClientsByPortion(int portionSize);

    void showClientsGtSum(int sum);

    void showClientsLastMonth();

    Long create(Client client);

    Client read(Long id);

    boolean update(Client client);

    boolean delete(Client client);

    List<Client> findAll();

    List<Client> findAllByPortion(int first, int result);

    List<Client> findAllGtSumm(Double sum);

    List<Client> findAllLastMonth();
}
