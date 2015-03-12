package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.ClientException;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface ClientService {
    Long createClient(String name, String surname, String phone, String address) throws ClientException;
    List getClientsByPortion(int portionSize);
    List getClientsGtSum(int sum);
    List getClientsLastMonth();
}

