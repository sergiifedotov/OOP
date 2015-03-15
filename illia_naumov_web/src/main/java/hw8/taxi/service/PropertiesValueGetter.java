package hw8.taxi.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by illia_naumov on 06.03.2015.
 */
public class PropertiesValueGetter {
    Properties prop = new Properties();
    String propFileName = "config.properties";

    public PropertiesValueGetter(){

    }
    public PropertiesValueGetter(String propFileName){
        this.propFileName = propFileName;
    }

    public  String getAttempts() throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        }

        inputStream.close();
        String user = prop.getProperty("attempts");
        return user;
    }
}
