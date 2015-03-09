package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;
    List<Client> showClientsByPortion(int portionSize);
    List<Client> showClientsGtSum(int sum);
    List<Client> showClientsLastMonth();
    List getClientsByPortion(int portionSize);

}

