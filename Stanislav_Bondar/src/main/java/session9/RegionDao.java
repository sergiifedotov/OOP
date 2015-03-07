package session9;

import session9.Region;

import java.util.List;

/**
* Created by stan on 08.02.15.
*/
public interface RegionDao {
    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
    List<Region> findAll();
}
