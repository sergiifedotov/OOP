package Weekend_7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sanya on 22.02.2015.
 */
@Service
public class ServiceRegionImpl implements ServiceRegion {

    @Autowired
    private RegionDao regionDao;

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }
}
