package hw9.taxi.service;

import hw9.taxi.controller.OrderException;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;
    void showClientsByPortion(int portionSize);
    void showClientsGtSum(int sum);
    void showClientsLastMonth();
}
