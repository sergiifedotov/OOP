package hw9.taxi.dao;



import hw9.taxi.domain.Client;

import java.util.Date;
import java.util.List;

/**
 * Created by sanya on 11.03.2015.
 */
public interface ClientDao {

    Long create(Client client);

    Client read(Long id);

    boolean update(Client client);

    boolean delete(Client client);

    List<Client> findAll();

    List<Client> findAllByPortion(int first, int result);

    List<Client> findAllGtSumm(Double sum);

    List<Client> findAllLastMonth(Date toDay, Date dayBeforeMonth);
}
