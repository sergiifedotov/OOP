package hw9.taxi.dao;

import hw9.taxi.domain.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    List findAll();

    List getClientsByPortion(int portionSize);
    List getClientsGtSum(int sum);
    List getClientsLastMonth();
}
