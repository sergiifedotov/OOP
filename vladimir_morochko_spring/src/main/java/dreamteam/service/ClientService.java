package dreamteam.service;

import hw9.taxi.exception.ClientException;

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

