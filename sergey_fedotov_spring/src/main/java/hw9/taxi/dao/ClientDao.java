package hw9.taxi.dao;

import hw9.taxi.domain.Client;

import java.util.List;

/**
 */
public interface ClientDao {

    Long create(Client client);

    List<Client> getClientsByPortion(int portionSize);
    List<Client> getClientsGtSum(int sum);
    List<Client> getClientsLastMonth();

}
