package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;
    void showClientsByPortion(int portionSize);
    void showClientsGtSum(int sum);
    void showClientsLastMonth();
    List getClientsByPortion(int portionSize);

}

