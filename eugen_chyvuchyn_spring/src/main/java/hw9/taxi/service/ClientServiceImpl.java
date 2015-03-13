package hw9.taxi.service;

import hw9.taxi.exception.OrderException;

/**
 * Created by Chuvychin on 13.03.2015.
 */
public class ClientServiceImpl implements ClientService {
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        return false;
    }

    @Override
    public void showClientsByPortion(int portionSize) {

    }

    @Override
    public void showClientsGtSum(int sum) {

    }

    @Override
    public void showClientsLastMonth() {

    }
}
