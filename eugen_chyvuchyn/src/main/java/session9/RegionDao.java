package session9;

import java.util.List;

/**
 * Created by Chuvychin on 08.02.2015.
 */
public interface RegionDao {
    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
    List<Region> findAll();
    List<Region> findAllThisName();
}
