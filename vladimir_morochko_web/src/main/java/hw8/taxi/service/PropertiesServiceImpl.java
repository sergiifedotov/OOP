package hw8.taxi.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by vladimir on 07.03.2015.
 */
public class PropertiesServiceImpl implements PropertiesService {

    public static PropertiesService propertiesService = new PropertiesServiceImpl();

    private Properties properties;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private String propertiesFileName;

    public PropertiesServiceImpl() {
        //propertiesFileName = "conf.properties";
        propertiesFileName = "C:/Users/vladimir/IdeaProjects/proff21/vladimir_morochko_web/src/main/resources/hw8/taxi/conf.properties"; //TODO WTF???
        properties = new Properties();
        loadProperties();
    }

    @Override
    public void loadProperties() {
        try {
            fileInputStream = new FileInputStream(propertiesFileName);
            properties.loadFromXML(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveProperties() {
        try {
            fileOutputStream = new FileOutputStream(propertiesFileName);
            properties.storeToXML(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Integer getOrderPortionSize() {
        return Integer.parseInt(properties.getProperty("orderPortionSize"));
    }

    @Override
    public void setOrderPortionSize(Integer orderPortionSize) {
        properties.setProperty("orderPortionSize", orderPortionSize.toString());
    }

    @Override
    public Integer getAllowedLoginAttempts() {
        return Integer.parseInt(properties.getProperty("allowedLoginAttempts"));
    }

    @Override
    public void setAllowedLoginAttempts(Integer allowedLoginAttempts) {
        properties.setProperty("allowedLoginAttempts", allowedLoginAttempts.toString());
    }

    @Override
    public Integer getClientPortionSize() {
    return Integer.parseInt(properties.getProperty("clientPortionSize"));
}

    @Override
    public void setClientPortionSize(Integer clientPortionSize) {
        properties.setProperty("clientPortionSize", clientPortionSize.toString());
    }
}
