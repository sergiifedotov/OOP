package session10;

import javax.swing.plaf.synth.Region;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public interface RegionDao {
    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
    List<Region> findAll();
}
