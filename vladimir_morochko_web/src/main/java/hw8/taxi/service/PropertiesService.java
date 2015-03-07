package hw8.taxi.service;

/**
 * Created by vladimir on 07.03.2015.
 */
public interface PropertiesService {
    void loadProperties();
    void saveProperties();

    Integer getOrderPortionSize();
    void setOrderPortionSize(Integer orderPortionSize);

    Integer getAllowedLoginAttempts();
    void setAllowedLoginAttempts(Integer allowedLoginAttempts);

    Integer getClientPortionSize();
    void setClientPortionSize(Integer clientPortionSize);
}
