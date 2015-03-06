package hw8.taxi.dao;

import hw8.taxi.domain.Client;

import java.util.List;

/**
 * Created by Tanya on 05.03.2015.
 */
public interface ClientDao {
    public  Long create(Client client);
    public Client read(Long id);
    public boolean update(Client client);
    public boolean delete(Client client);
    public List<Client> findAll();
}
