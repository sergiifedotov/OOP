package session12.companyDao;

import java.util.Set;

/**
 * Created by @CAT_Caterpiller on 15.02.2015.
 */
public interface CompanyDao {
    void setFond(int fond);
    int getFond();
    Set<Employee> returnAll();
}
