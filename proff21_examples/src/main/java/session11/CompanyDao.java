package session11;

import java.util.List;

/**
 * Created by stan on 15.02.15.
 */
public interface CompanyDao {



    Long create(final Company company);

    Company read(final Long id);

    void update(final Company company);

    void delete(final Company company);

    List<Company> findAll();

    List<Company> findAllPartially(final int startRange, final int range);

    Long rowsCount();

    Company findByName(final String name);

}